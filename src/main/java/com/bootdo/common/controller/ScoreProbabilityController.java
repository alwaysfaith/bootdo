package com.bootdo.common.controller;


import cn.hutool.core.date.DateUtil;
import com.bootdo.common.dao.DsScoreMatchDao;
import com.bootdo.common.domain.DsScoreMatchDO;
import com.bootdo.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ECHO
 */
@Slf4j
@RestController
@RequestMapping("/probability")
public class ScoreProbabilityController {

    private static final int MAX_PAGE_SIZE = 100;

    private static final String SEPARATOR_PREFIX = "/";

    @Autowired
    DsScoreMatchDao dsScoreMatchDao;

    public static void main(String[] args) {
        String connectUrl = "https://www.dszuqiu.com/diary/20180601";
        List<DsScoreMatchDO> scoreMatchList = getDsScoreMatchDos(connectUrl);
        log.warn("scoreMatchList.size()>>>>>" + scoreMatchList.size());
        //如果大于等于100
        if (scoreMatchList.size() >= MAX_PAGE_SIZE) {
            AtomicInteger pageNum = new AtomicInteger(0);
            boolean hasMore = true;
            while (hasMore) {
                String connectUrl2 = "https://www.dszuqiu.com/diary/20180601/p." + pageNum.incrementAndGet();
                log.warn("connectUrl2>>>>>>:{}", connectUrl2);
                List<DsScoreMatchDO> matchDoList = getDsScoreMatchDos(connectUrl2);
                scoreMatchList.addAll(matchDoList);
                hasMore = matchDoList.size() == MAX_PAGE_SIZE;
            }
        }
        scoreMatchList.parallelStream()
                .forEach(x->{

                });

        log.warn("scoreMatchList总大小>>>>>>>>>>>>>>>>>>>>" + scoreMatchList.size());
    }

    public static List<DsScoreMatchDO> getDsScoreMatchDos(String connectUrl) {
        Document doc = null;
        try {
            doc = Jsoup.connect(connectUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36").get();
        } catch (IOException e) {
            log.error("jsoup connect error:{}", e);
            e.printStackTrace();
        }
        Elements select = Objects.requireNonNull(doc).select("table.live-list-table.diary-table");
        Elements trTags = select.select("tr");
        List<DsScoreMatchDO> scoreMatchList = new ArrayList<>();

        trTags.forEach(x -> {
            Elements td = x.select("td");
            if (td.size() > 1) {
                DsScoreMatchDO matchDO = new DsScoreMatchDO(
                        // match
                        StringUtils.trim(td.get(0).select("a").text()),
                        // matchBg
                        StringUtils.trim(td.get(0).attr("class")),
                        // selection todo
                        StringUtils.trim(td.get(1).ownText()),
                        // startTime
                        StringUtils.trim(td.get(2).ownText()),
                        // hostTeam
                        StringUtils.trim(td.get(3).select("a").text()),
                        // hostRank
                        td.get(3).select("span.leagueRank").size() > 0 ? StringUtils.trim(td.get(3).select("span.leagueRank").text()) : null,
                        // hostRed
                        td.get(3).select("span.redCard").size() > 0 ? StringUtils.trim(td.get(3).select("span.redCard").text()) : null,
                        // hostYellow
                        td.get(3).select("span.yellowCard").size() > 0 ? StringUtils.trim(td.get(3).select("span.yellowCard").text()) : null,
                        // overScore
                        StringUtils.trim(td.get(4).text()),
                        // guestTeam
                        StringUtils.trim(td.get(5).select("a").text()),
                        // guestRank
                        td.get(5).select("span.leagueRank").size() > 0 ? StringUtils.trim(td.get(5).select("span.leagueRank").text()) : null,
                        // guestRed
                        td.get(5).select("span.redCard").size() > 0 ? StringUtils.trim(td.get(5).select("span.redCard").text()) : null,
                        // guestYellow
                        td.get(5).select("span.yellowCard").size() > 0 ? StringUtils.trim(td.get(5).select("span.yellowCard").text()) : null,
                        // halfScore
                        StringUtils.trim(td.get(6).ownText()),
                        // letBall
                        StringUtils.trim(
                                td.get(7).text().split(SEPARATOR_PREFIX).length >= 1 ? td.get(7).text().split(SEPARATOR_PREFIX)[0] : null
                        ),
                        // sizeBall
                        StringUtils.trim(StringUtils.trim(
                                td.get(7).text().split(SEPARATOR_PREFIX).length >= 2 ? td.get(7).text().split(SEPARATOR_PREFIX)[1] : null
                        )),
                        // cornerBall
                        StringUtils.trim(StringUtils.trim(
                                td.get(7).text().split(SEPARATOR_PREFIX).length >= 3 ? td.get(7).text().split(SEPARATOR_PREFIX)[2] : null
                        )),
                        // halfCorner
                        StringUtils.trim(td.get(9).ownText()),
                        // overCorner
                        StringUtils.trim(td.get(10).ownText()),
                        // matchTime
                        DateUtil.parse("20180601")
                );
                scoreMatchList.add(matchDO);
            }
        });
        return scoreMatchList;
    }

}

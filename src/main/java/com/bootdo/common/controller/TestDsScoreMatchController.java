package com.bootdo.common.controller;

import com.bootdo.common.domain.DsScoreMatchDO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.bootdo.common.controller.ScoreProbabilityController.getDsScoreMatchDos;

/**
 * @author : Caixin
 * @date 2019/8/13 21:01
 */
@Slf4j
public class TestDsScoreMatchController {

    private static final int MAX_PAGE_SIZE = 100;

    private static final String ST_CENTURY_PREFIX = "20";

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("20180601", "20180602");

        List<DsScoreMatchDO> scoreMatchDoList = new ArrayList<>();
        strings.forEach(x->{
            AtomicInteger pageNum = new AtomicInteger(0);
            boolean hasMore = true;
            while (hasMore){
                String connectUrl = "https://www.dszuqiu.com/diary/"+x+"/p." + pageNum.incrementAndGet();
                log.warn(">>>>>>>>>>>>>>>>>>>Jsoup connect url:{}>>>>>>>>>>>>>>>>>>>>>>>", connectUrl);
                List<DsScoreMatchDO> matchDoList = getDsScoreMatchDos(connectUrl);
                List<DsScoreMatchDO> scoreMatchDo = matchDoList.stream()
                        .filter(y -> {
                            String builder = ST_CENTURY_PREFIX +
                                    y.getStartTime().split(" ")[0].replace("/", "");
                            return !builder.equalsIgnoreCase(x);
                        }).collect(Collectors.toList());
                if(CollectionUtils.isNotEmpty(scoreMatchDo)){
                    throw new RuntimeException("日期格式不匹配！");
                }

                scoreMatchDoList.addAll(matchDoList);
                hasMore = matchDoList.size() == MAX_PAGE_SIZE;
            }
        });
        log.warn(">>>>>>>>>>>>>>>>>>>>>>DsScoreMatchDO:{}>>>>>>>>>>>>>>>>>>>>>>>",scoreMatchDoList.size());

    }
}

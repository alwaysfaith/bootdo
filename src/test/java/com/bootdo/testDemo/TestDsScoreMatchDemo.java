package com.bootdo.testDemo;

import com.bootdo.common.dao.DsScoreMatchDao;
import com.bootdo.common.domain.DsScoreMatchDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.bootdo.common.controller.ScoreProbabilityController.getDsScoreMatchDos;

/**
 * @author : Caixin
 * @date 2019/8/8 15:38
 */
@Slf4j
public class TestDsScoreMatchDemo extends TestDemo {

    /**
     * 1、查询所有年份的大小球、赛事大小球、初盘让球大小球、角球等
     * 2、查询半场比分和全场比分相差
     * 3、查询角球半场比分和全场角球比分
     * 4、查询初盘让球
     */


    @Autowired
    DsScoreMatchDao dsScoreMatchDao;

    @Test
    public void testDsScoreMatch() throws IOException {
        String connectUrl = "https://www.dszuqiu.com/diary/20180601";
        List<DsScoreMatchDO> scoreMatchList = getDsScoreMatchDos(connectUrl);
        //如果大于等于100
        if (scoreMatchList.size() >= 100) {
            AtomicInteger pageNum = new AtomicInteger(0);
            boolean hasMore = true;
            while (hasMore) {
                String connectUrl2 = "https://www.dszuqiu.com/diary/20180601/p." + pageNum.incrementAndGet();
                List<DsScoreMatchDO> matchDoList = getDsScoreMatchDos(connectUrl2);
                scoreMatchList.addAll(matchDoList);
                hasMore = matchDoList.size() == 100;
            }
        }
        scoreMatchList.parallelStream()
                .forEach(x -> {
                    dsScoreMatchDao.save(x);
                });
        log.warn("scoreMatchList总大小>>>>>>>>>>>>>>>>>>>>" + scoreMatchList.size());
    }
}

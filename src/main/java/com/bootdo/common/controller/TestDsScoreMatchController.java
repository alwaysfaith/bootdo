package com.bootdo.common.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.bootdo.common.domain.DsScoreMatchDO;
import com.bootdo.common.dto.DsScoreMatchDTO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.bootdo.common.controller.ScoreProbabilityController.getDsScoreMatchDos;
import static java.util.stream.Collectors.toList;

/**
 * @author : Caixin
 * @date 2019/8/13 21:01
 */
@Slf4j
@RestController
@Component
@RequestMapping("/common/dsScoreMatch")
public class TestDsScoreMatchController {

    private static final int MAX_PAGE_SIZE = 100;

    private static final int MAX_SOTRE_NUMBER = 1000;

    private static final String ST_CENTURY_PREFIX = "20";

    private static final String INSERT_STORE_SQL = "insert into `ds_score_match`(`match`,`match_bg`,`selection`,`start_time`,`host_team`,`host_rank`,`host_red`,`host_yellow`,`over_score`,`guest_team`,`guest_rank`,`guest_red`,`guest_yellow`,`half_score`,`let_ball`,`size_ball`,`corner_ball`,`half_corner`,`over_corner`,`match_time`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Resource(name = "importPool")
    private ThreadPoolExecutor poolExecutor;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    public static void main(String[] args) {
        //获取一个月的数据
//        DateTime dateTimeStart = DateUtil.parse("2019-07-01");
//        DateTime dateTimeEnd = DateUtil.parse("2019-08-01");
//
//        DateTime endOfMonth = DateUtil.endOfMonth(dateTimeEnd);
//        String endOfMonthFormat = DateUtil.format(endOfMonth, "yyyy-MM-dd");
//        DateTime dateEnd = DateUtil.parse(endOfMonthFormat);
//        List<String> strings = findDates(dateTimeStart, dateEnd);
//
//        strings.forEach(System.out::println);


        DateTime dateTimeStart1 = DateUtil.parse("2019-07-01");
        DateTime dateTimeEnd1 = DateUtil.parse("2019-08-13");
        if (dateTimeEnd1.isAfterOrEquals(DateUtil.beginOfDay(new Date()))) {
            throw new RuntimeException("截止日期不能超过当前日期");
        }

        List<String> strings1 = findDates(dateTimeStart1, dateTimeEnd1);
        strings1.forEach(System.out::println);

    }


    @GetMapping("/test")
    public void testDsScoreMatch() {
        //获取一个月的数据
//        DateTime dateTimeStart = DateUtil.parse("2019-07-01");
//        DateTime dateTimeEnd = DateUtil.parse("2019-07-01");
//
//        DateTime endOfMonth = DateUtil.endOfMonth(dateTimeEnd);
//        String endOfMonthFormat = DateUtil.format(endOfMonth, "yyyy-MM-dd");
//        DateTime dateEnd = DateUtil.parse(endOfMonthFormat);
//        List<String> strings = findDates(dateTimeStart, dateEnd);

        DateTime dateTimeStart1 = DateUtil.parse("2019-07-01");
        DateTime dateTimeEnd1 = DateUtil.parse("2019-07-02");
        if (dateTimeEnd1.isAfterOrEquals(DateUtil.beginOfDay(new Date()))) {
            throw new RuntimeException("截止日期不能超过当前日期");
        }

        List<String> strings = findDates(dateTimeStart1, dateTimeEnd1);


        List<DsScoreMatchDO> scoreMatchDoList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("数据拉取操作时间>>>>>>>>>>>>>>>>>>>>>>>>>>");
        strings.forEach(x -> {
            AtomicInteger pageNum = new AtomicInteger(0);
            boolean hasMore = true;
            while (hasMore) {
                String connectUrl = "https://www.dszuqiu.com/diary/" + x + "/p." + pageNum.incrementAndGet();
                log.warn(">>>>>>>>>>>>>>>>>>>Jsoup connect url:{}>>>>>>>>>>>>>>>>>>>>>>>", connectUrl);
                List<DsScoreMatchDO> matchDoList = getDsScoreMatchDos(connectUrl);
                List<DsScoreMatchDO> scoreMatchDo = matchDoList.stream()
                        .filter(y -> {
                            String builder = ST_CENTURY_PREFIX +
                                    y.getStartTime().split(" ")[0].replace("/", "");
                            return !builder.equalsIgnoreCase(x);
                        }).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(scoreMatchDo)) {
                    throw new RuntimeException("日期格式不匹配！");
                }
                scoreMatchDoList.addAll(matchDoList);
                hasMore = matchDoList.size() == MAX_PAGE_SIZE;
            }
        });
        stopWatch.stop();
        log.warn(">>>>>>>>>>>>>>>>>>>>>>DsScoreMatchDO:{}>>>>>>>>>>>>>>>>>>>>>>>", scoreMatchDoList.size());

        stopWatch.start("分割" + MAX_SOTRE_NUMBER + "List所用时间>>>>>>>>>>>>");
        List<List<DsScoreMatchDO>> partitionList = Lists.partition(scoreMatchDoList, MAX_SOTRE_NUMBER);
        stopWatch.stop();

        stopWatch.start("CompletableFuture 入库所用时间>>>>>>>>>>>>>>>>>>>>>>>");
        List<CompletableFuture<DsScoreMatchDTO>> completableFutures = partitionList.stream().map(list -> CompletableFuture.supplyAsync(() -> {
            DsScoreMatchDTO errorDTO = new DsScoreMatchDTO();
            errorDTO.setFlag(Boolean.TRUE);
            insert2Store(list);
            return errorDTO;
        }, poolExecutor).exceptionally(throwable -> {
            //如果出现异常
            DsScoreMatchDTO errorDTO = new DsScoreMatchDTO();
            errorDTO.setFlag(Boolean.FALSE);
            errorDTO.setDsScoreMatchList(list);
            return errorDTO;
        })).collect(Collectors.toList());
        stopWatch.stop();

        List<DsScoreMatchDTO> matchDoList = sequence(completableFutures).join();

        Map<Boolean, List<DsScoreMatchDTO>> listMap = matchDoList.stream()
                .collect(Collectors.partitioningBy(DsScoreMatchDTO::getFlag));

        List<DsScoreMatchDTO> falseMatch = listMap.get(Boolean.FALSE);
        log.error("导入成功List:{}", listMap.get(Boolean.TRUE).size());
        log.error("导入失败List:{}", falseMatch.size());

        //失败List重试一次
        if (CollectionUtils.isNotEmpty(falseMatch)) {
            log.error("失败List重试一次:{}", falseMatch.size());
            falseMatch.forEach(x -> insert2Store(x.getDsScoreMatchList()));
        }

        log.warn(">>>>>>>>>>>>>>>>拉取导入数据耗时: {}", stopWatch.prettyPrint());
    }

    private static List<String> findDates(Date dBegin, Date dEnd) {
        List<String> lDate = new ArrayList<>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        lDate.add(sd.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sd.format(calBegin.getTime()));
        }
        return lDate;
    }


    /**
     * 构造结果集
     *
     * @param futuresList
     * @param <T>
     * @return
     */
    private <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futuresList) {
        return CompletableFuture.allOf(futuresList.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> futuresList.stream()
                        .map(CompletableFuture::join)
                        .collect(toList())
                );

    }

    private void insert2Store(List<DsScoreMatchDO> list) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            DruidDataSource druidDataSource = (DruidDataSource) dataSourceTransactionManager.getDataSource();
            Class.forName(Objects.requireNonNull(druidDataSource).getDriverClassName());
            conn = DriverManager.getConnection(druidDataSource.getUrl(), druidDataSource.getUsername(), druidDataSource.getPassword());
            pstm = conn.prepareStatement(INSERT_STORE_SQL);
            conn.setAutoCommit(false);
            for (DsScoreMatchDO matchDO : list) {
                pstm.setString(1, matchDO.getMatch());
                pstm.setString(2, matchDO.getMatchBg());
                pstm.setString(3, matchDO.getSelection());
                pstm.setString(4, matchDO.getStartTime());
                pstm.setString(5, matchDO.getHostTeam());
                pstm.setString(6, matchDO.getHostRank());
                pstm.setString(7, matchDO.getHostRed());
                pstm.setString(8, matchDO.getHostYellow());
                pstm.setString(9, matchDO.getOverScore());
                pstm.setString(10, matchDO.getGuestTeam());
                pstm.setString(11, matchDO.getGuestRank());
                pstm.setString(12, matchDO.getGuestRed());
                pstm.setString(13, matchDO.getGuestYellow());
                pstm.setString(14, matchDO.getHalfScore());
                pstm.setString(15, matchDO.getLetBall());
                pstm.setString(16, matchDO.getSizeBall());
                pstm.setString(17, matchDO.getCornerBall());
                pstm.setString(18, matchDO.getHalfCorner());
                pstm.setString(19, matchDO.getOverCorner());
                pstm.setDate(20, new java.sql.Date(matchDO.getMatchTime().getTime()));
                pstm.addBatch();
            }

            //模拟异常
//            boolean b = new Random().nextInt() % 2 >= 0;
//            if (b) {
//                System.out.println(1 / 0);
//            }

            pstm.executeBatch();
            conn.commit();
        } catch (Exception e) {
            log.error("异常=================>>>>:{}", e.getMessage());
            try {
                if (null != conn) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

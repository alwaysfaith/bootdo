package com.bootdo.testDemo;

import com.bootdo.system.dao.UserDao;
import com.bootdo.system.domain.UserDO;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("a", "b");
        System.out.println(redisTemplate.opsForValue().get("a"));
    }

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
    private ExecutorService executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+1,
            10L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Test
    public void testInsertBatch2() throws Exception {
        long start = System.currentTimeMillis();
        UserDO user;
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);//跟上述sql区别
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        for (int i = 0; i < 50000; i++) {
            user = new UserDO();
            user.setName("name" + i);
            user.setUsername(String.valueOf(i));
            user.setPassword(String.valueOf(i));
            user.setDeptName(String.valueOf(i));
            user.setDeptId((long) i);
            user.setBirth(new Date());
            user.setCity("Shanghai");
            user.setEmail(String.valueOf(i));
            user.setMobile(String.valueOf(i));
            user.setStatus(0);
            mapper.save(user);
        }
        sqlSession.commit();
        long end = System.currentTimeMillis();
        sqlSession.close();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + (end - start) + ">>>>>>>>>>>>>>>>>>>>>>>>");
    }


    @Test
    public void insertCrossEvaluation() {
        List<UserDO> dbList = new ArrayList<>();
        long start = System.currentTimeMillis();
        UserDO user;
        for (int i = 0; i < 501; i++) {
            user = new UserDO();
            user.setName("name" + i);
            user.setUsername(String.valueOf(i));
            user.setPassword(String.valueOf(i));
            user.setDeptName(String.valueOf(i));
            user.setDeptId((long) i);
            user.setBirth(new Date());
            user.setCity("Shanghai");
            user.setEmail(String.valueOf(i));
            user.setMobile(String.valueOf(i));
            user.setStatus(0);
            dbList.add(user);
        }

        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            UserDao mapper = batchSqlSession.getMapper(UserDao.class);
            int batchCount = 500;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            //限制条数
//            int pointsDataLimit = 500;
//            Integer size = trueResult2.size();
//            if (pointsDataLimit < size) {
//                //分批数
//                int part = size / pointsDataLimit;
//                System.out.println("共有 ： " + size + "条！" + " 分为 ：" + part + "批");
//                CountDownLatch latch3 = new CountDownLatch(part);
//                for (int i = 0; i < part; i++) {
//                    //1000条
//                    List<UserDO> relationDTOS = trueResult2.subList(0, pointsDataLimit);
//                    SqlSession finalBatchSqlSession = batchSqlSession;
//                    executor.execute(() -> {
//                        try {
//                            mapper.batchSave(relationDTOS);
//                            finalBatchSqlSession.commit();
//                        } finally {
//                            latch3.countDown();
//                        }
//                    });
//                    //剔除
//                    trueResult2.subList(0, pointsDataLimit).clear();
//                }
//                try {
//                    latch3.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (!trueResult2.isEmpty()) {
//                    //表示最后剩下的数据
//                    mapper.batchSave(trueResult2);
//                }
//            } else {
//                mapper.batchSave(trueResult2);
//                batchSqlSession.commit();
//            }

            if (dbList.size() > 500) {
                for (int index = 0; index < dbList.size(); ) {
                    if (batchLastIndex > dbList.size()) {
                        mapper.batchSave(dbList.subList(index, batchLastIndex));
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>"+dbList.subList(index, batchLastIndex).size());
                        batchSqlSession.commit();
                        System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
                        break;// 数据插入完毕，退出循环
                    } else {
                        mapper.batchSave(dbList.subList(index, batchLastIndex));
                        batchSqlSession.commit();
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+dbList.subList(index, batchLastIndex));
                        System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
                        index = batchLastIndex;// 设置下一批下标
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
                batchSqlSession.commit();
            } else {
                mapper.batchSave(dbList);
                batchSqlSession.commit();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            assert batchSqlSession != null;
            batchSqlSession.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + (end - start) + ">>>>>>>>>>>>>>>>>>>>>>>>");
//        return Tools.getBoolean(result);
    }

}

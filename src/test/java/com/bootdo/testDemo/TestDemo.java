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

import java.time.Clock;
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
    private ExecutorService executor = new ThreadPoolExecutor(corePoolSize, corePoolSize + 1,
            10L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Test
    public void testScoreProbability() throws Exception {
        long millis1 = Clock.systemDefaultZone().millis();
        /**
         *
         * 盘口查询： (-0.25   -0.5  -0.75  -1 -1.25 -1.5 -1.75 -2 -2.25  0  0.25 0.5 0.75 1 1.25  1.5 1.75 2)
         * 让球   受*平/半     同初盘               http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.25&n=5&t=1&l=0
         * 让球   受*平/半     同终盘               http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.25&n=5&t=2&l=0
         * 让球   受*平/半     初盘终盘相同     http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.25&n=5&t=3&l=0
         *
         *让球   受*半球      同初盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.5&n=5&t=1&l=0
         *让球   受*半球      同终盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.5&n=5&t=2&l=0
         *让球   受*半球      初盘终盘相同      http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.5&n=5&t=3&l=0
         *
         *让球   受*半/一     同初盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.75&n=5&t=1&l=0
         *让球   受*半/一     同终盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.75&n=5&t=2&l=0
         *让球   受*半/一     初盘终盘相同      http://vip.win0168.com/history/SearchSameGoal.aspx?g=-0.75&n=5&t=3&l=0
         *
         *让球   受*一球     同初盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-1&n=5&t=1&l=0
         *让球   受*一球     同终盘                http://vip.win0168.com/history/SearchSameGoal.aspx?g=-1&n=5&t=2&l=0
         *让球   受*一球     初盘终盘相同      http://vip.win0168.com/history/SearchSameGoal.aspx?g=-1&n=5&t=3&l=0
         *
         *
         *  大小
         *
         */
        long millis2 = Clock.systemDefaultZone().millis();
        System.out.println("耗时：{}" + (millis2 - millis1));

    }


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


//    public class MyThreadPoolExecutor extends ThreadPoolExecutor {
//        private Logger log = LoggerFactory.getLogger(MyThreadPoolExecutor.class);
//
//        private ReentrantLock pauseLock = new ReentrantLock();
//        private Condition unpaused = pauseLock.newCondition();
//
//        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
//            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
//        }
//
//        /**
//         * 重写，覆盖并弃用父类的awaitTermination方法 </br>
//         * 所以，这里传的两个参数将无效，可以随便传
//         */
//        @Override
//        public boolean awaitTermination(long timeout, TimeUnit unit) {
//            //阻塞，不让主程序死掉，到时候这里传异常信号量，出现异常则推送信号数据到这里while(flag)
//            int i = 0;
//            while (i < 10) {
//                pauseLock.lock();
//                try {
//                    i++;
//                    System.out.println(i);
//                    unpaused.await();
//                } catch (InterruptedException e) {
//                    log.error("", e);
//                } finally {
//                    pauseLock.unlock();
//                }
//            }
//            return true;
//        }
//    }


    class MyThreadPoolExecutor extends ThreadPoolExecutor {
        private boolean hasFinish = false;

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
            // TODO Auto-generated constructor stub
        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                    threadFactory, handler);
            // TODO Auto-generated constructor stub

        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                    threadFactory);
            // TODO Auto-generated constructor stub
        }

        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
            // TODO Auto-generated constructor stub
        }

        /* (non-Javadoc)
         * @see java.util.concurrent.ThreadPoolExecutor#afterExecute(java.lang.Runnable, java.lang.Throwable)
         */
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            // TODO Auto-generated method stub
            super.afterExecute(r, t);
            synchronized (this) {
                System.out.println("自动调用了....afterEx 此时getActiveCount()值:" + this.getActiveCount());
                if (this.getActiveCount() == 1)//已执行完任务之后的最后一个线程
                {
                    this.hasFinish = true;
                    this.notify();
                }//if
            }// synchronized
        }

        public void isEndTask() {
            synchronized (this) {
                while (!this.hasFinish) {
                    System.out.println("等待线程池所有任务结束: wait...");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
//           TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

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
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>" + dbList.subList(index, batchLastIndex).size());
                        batchSqlSession.commit();
                        System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
                        break;// 数据插入完毕，退出循环
                    } else {
                        mapper.batchSave(dbList.subList(index, batchLastIndex));
                        batchSqlSession.commit();
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + dbList.subList(index, batchLastIndex));
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

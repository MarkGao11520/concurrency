package com.gwf.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author gaowenfeng02
 * @date 2018-03-16
 */
@Slf4j
public abstract class AbstractExample {
    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public void test() throws InterruptedException{
        // 创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), r -> new Thread(r,"测试线程"));
        // 信号量，闭锁
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        // 模拟并发请求
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    // 请求一个信号，如果信号量小于clientTotal，则阻塞
                    semaphore.acquire();
                    add();
                    // 释放一个信号
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        // 阻塞直到countDown 的次数为threadTotal
        countDownLatch.await();
        // 关闭线程池
        executorService.shutdown();
        countLog();
    }

    protected abstract void add();

    protected abstract void countLog();


}

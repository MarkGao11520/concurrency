package com.gwf.concurrency;

import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
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
        log.info("count:{}",count);

    }

    /**
     * 本质上应该是这个方法线程不安全
     */
    private static void add(){
        count++;
    }
}

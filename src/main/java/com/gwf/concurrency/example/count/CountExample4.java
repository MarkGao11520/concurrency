package com.gwf.concurrency.example.count;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class CountExample4 extends AbstractExample{

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        new CountExample4().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     *
     * volatile只能保证 1，2，3的顺序不会被重排序
     * 但是不保证1，2，3的原子执行，也就是说还是有可能有两个线程交叉执行1，导致结果不一致
     */
    @Override
    protected void add() {
        // 1.取内存中的count值
        // 2.count值加1
        // 3.重新写会主存
        count++;
    }

    @Override
    protected void countLog() {
        log.info("count:{}",count);
    }


}

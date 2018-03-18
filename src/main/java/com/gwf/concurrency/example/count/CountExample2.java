package com.gwf.concurrency.example.count;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class CountExample2 extends AbstractExample{

    public static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        new CountExample2().test();
    }

    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add(){
        count.incrementAndGet();
    }

    @Override
    protected void countLog() {
        log.info("count:{}",count);
    }
}

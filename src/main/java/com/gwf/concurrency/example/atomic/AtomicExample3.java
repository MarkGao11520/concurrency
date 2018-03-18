package com.gwf.concurrency.example.atomic;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 extends AbstractExample{

    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        new AtomicExample3().test();
    }

    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add(){
        count.increment();
    }

    @Override
    protected void countLog() {
        log.info("count:{}",count);
    }
}

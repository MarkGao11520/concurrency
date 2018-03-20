package com.gwf.concurrency.example.count;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class CountExample3 extends AbstractExample{


    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        new CountExample3().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected synchronized void add() {
        count++;
    }

    @Override
    protected void countLog() {
        log.info("count:{}",count);
    }


}

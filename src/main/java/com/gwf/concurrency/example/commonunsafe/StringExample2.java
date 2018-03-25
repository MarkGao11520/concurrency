package com.gwf.concurrency.example.commonunsafe;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class StringExample2 extends AbstractExample{

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public static StringBuffer stringBuffer = new StringBuffer();


    public static void main(String[] args) throws InterruptedException {
        new StringExample2().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add() {
        stringBuffer.append(1);
    }

    @Override
    protected void countLog() {
        log.info("stringBuilder:{}",stringBuffer.length());
    }


}

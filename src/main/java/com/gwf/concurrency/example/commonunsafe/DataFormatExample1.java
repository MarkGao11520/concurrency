package com.gwf.concurrency.example.commonunsafe;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class DataFormatExample1 extends AbstractExample{

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws InterruptedException {
        new DataFormatExample1().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add() {
        try {
            // 在多线程并发执行的时候会抛出异常
            dateFormat.parse("20180208");
        } catch (ParseException e) {
            log.error("parse exception",e);
        }
    }

    @Override
    protected void countLog() {
    }


}

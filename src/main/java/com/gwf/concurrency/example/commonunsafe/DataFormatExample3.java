package com.gwf.concurrency.example.commonunsafe;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.Recommend;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
@Recommend
public class DataFormatExample3 extends AbstractExample{

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");


    public static void main(String[] args) throws InterruptedException {
        new DataFormatExample3().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add() {
        DateTime.parse("20180320",dateTimeFormatter).toDate();
    }

    @Override
    protected void countLog() {
    }


}

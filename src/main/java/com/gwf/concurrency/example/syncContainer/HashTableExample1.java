package com.gwf.concurrency.example.syncContainer;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class HashTableExample1 extends AbstractExample{

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public static Map<Integer,Integer> map = new Hashtable<>();

    private static AtomicInteger i = new AtomicInteger(0);



    public static void main(String[] args) throws InterruptedException {
        new HashTableExample1().test();
    }


    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add() {
        map.put(i.getAndIncrement(),1);
    }

    @Override
    protected void countLog() {
        log.info("count:{}",map.size());
    }


}

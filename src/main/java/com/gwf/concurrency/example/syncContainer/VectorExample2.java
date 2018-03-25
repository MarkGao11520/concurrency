package com.gwf.concurrency.example.syncContainer;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.NotThreadSafe;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;

/**
 * 并发测试
 * 同步容器不一定线程安全
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    /** 请求总数 */
    public static int clientTotal = 5000;
    /** 同时并发执行的线程数 */
    public static int threadTotal = 50;

    public static List<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.remove(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            // thread2想范围i=9的元素的时候，thread1将i=9的元素移除了，导致数组越界
            for (int i = 0; i < 10; i++) {
                list.get(i);
            }
        });

        thread1.start();
        thread2.start();
    }

}

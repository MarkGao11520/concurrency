package com.gwf.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gaowenfeng
 * @date
 */
@Slf4j
public class SyncronizedExample2 {

    /**
     * 修饰类，括号包起来的代码
     * 作用对象为这个类的所有对象
     */
    public static void test1(){
        synchronized (SyncronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}",i);
            }
        }
    }


    /**
     * 修饰一个静态方法，作用对象为这个类的所有对象
     */
    public static synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}",i);
        }
    }

    public static void main(String[] args) {
        SyncronizedExample2 example1 = new SyncronizedExample2();
        SyncronizedExample2 example2 = new SyncronizedExample2();

        // 使用线程池模拟一个对象的两个进程同时调用一段sync代码的执行过程
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 线程pool-1-thread-1 先从0-9输出，然后pool-1-thread-2 从0到9顺序输出
        executorService.execute(()-> example1.test1());
        executorService.execute(()-> example1.test1());

        // 线程pool-1-thread-1 先从0-9输出，然后pool-1-thread-2 从0到9顺序输出
//        executorService.execute(()-> example1.test2());
//        executorService.execute(()-> example2.test2());




    }
}

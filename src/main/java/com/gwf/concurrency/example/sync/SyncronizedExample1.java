package com.gwf.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gaowenfeng
 * @date
 */
@Slf4j
public class SyncronizedExample1 {
    /**
     * 修饰一个代码块，作用范围为大括号括起来的
     */
    public void test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}",i);
            }
        }
    }

    /**
     * 修改方法，作用范围是整个方法，作用对象为调用这个方法的对象
     * 若子类继承父类调用父类的synchronized方法，是带不上synchronized关键字的
     * 原因：synchronized 不属于方法声明的一部分
     * 如果子类也想使用同步需要在方法上声明
     */
    public synchronized void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}",i);
        }
    }

    public static void main(String[] args) {
        SyncronizedExample1 example1 = new SyncronizedExample1();
        SyncronizedExample1 example2 = new SyncronizedExample1();

        // 使用线程池模拟一个对象的两个进程同时调用一段sync代码的执行过程
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 线程pool-1-thread-1,pool-1-thread-2 交叉输出
        executorService.execute(()-> example1.test1());
        executorService.execute(()-> example2.test1());


        // 线程pool-1-thread-1 先从0-9输出，然后pool-1-thread-2 从0到9顺序输出
        // executorService.execute(()-> example1.test1());
        // executorService.execute(()-> example1.test1());

    }
}

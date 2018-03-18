package com.gwf.concurrency.example.atomic;

import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    @Getter
    private volatile int count = 100;

    /**
     * AtomicIntegerFieldUpdater 核心是原子性的去更新某一个类的实例的指定的某一个字段
     * 构造函数第一个参数为类定义，第二个参数为指定字段的属性名，必须是volatile修饰并且非static的字段
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");


    public static void main(String[] args) throws InterruptedException {
        AtomicExample5 example5 = new AtomicExample5();

        // 第一次 count=100 -> count->120 返回True
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success 1:{}",example5.getCount());
        }

        // count=120 -> 返回False
        if(updater.compareAndSet(example5,100,120)){
            log.info("update success 2:{}",example5.getCount());
        }else {
            log.info("update field:{}",example5.getCount());

        }
    }

}

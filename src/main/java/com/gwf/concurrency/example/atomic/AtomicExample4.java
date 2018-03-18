package com.gwf.concurrency.example.atomic;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    public static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) throws InterruptedException {
        // 2
        count.compareAndSet(0,2);
        // no
        count.compareAndSet(0,1);
        // no
        count.compareAndSet(1,3);
        // 4
        count.compareAndSet(2,4);
        // 5
        count.compareAndSet(3,5);
        log.info("count:{}",count.get());
    }

}

package com.gwf.concurrency.example.atomic;

import com.gwf.concurrency.AbstractExample;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 extends AbstractExample{

    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        new AtomicExample6().test();
    }

    @Override
    protected void add() {
        if(isHappend.compareAndSet(false,true)){
            log.info("execute");
        }
    }

    @Override
    protected void countLog() {
        log.info("isHappend:{}",isHappend.get());
    }
}

package com.gwf.concurrency;

import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 并发测试
 * @author gaowenfeng
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest extends AbstractExample{

    public static int count = 0;

    /**
     * 本质上应该是这个方法线程不安全
     */
    @Override
    protected void add(){
        count++;
    }

    @Override
    protected void countLog() {

    }
}

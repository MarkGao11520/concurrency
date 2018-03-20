package com.gwf.concurrency.example.publish;

import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 不安全的发布
 * @author gaowenfeng
 * @date 2018-03-19
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states = {"a","b","c"};

    /**
     * 通过public发布级别发布了类的域，在类的外部，任何线程都可以访问这个域
     * 这样是不安全的，因为我们无法检查其他线程是否会修改这个域导致了错误
      * @return
     */
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}

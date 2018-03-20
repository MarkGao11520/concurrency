package com.gwf.concurrency.example.publish;

import com.gwf.concurrency.annoations.NotRecommend;
import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 * 在对象构造完成之前，不可以将其发布
 * @author gaowenfeng
 * @date
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCannBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    /**
     * 包含了对封装实例的隐藏和引用，这样在对象没有被正确构造完成之前就会被发布，由此导致不安全的因素在里面
     * 1.导致this引用在构造期间溢出的错误，他是在构造函数构造过程中启动了一个线程，造成this引用的溢出
     *   新线程只是在对象构造完毕之前就已经看到他了，所以如果要在构造函数中创建线程，那么不要启动它，
     *   而是应该才用一个专有的start，或是其他的方式统一启动线程
     *   使用工厂方法和私有构造函数来完成对象创建和监听器的注册来避免不正确的发布
     */
    private class  InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCannBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}

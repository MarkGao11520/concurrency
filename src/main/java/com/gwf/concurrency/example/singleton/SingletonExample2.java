package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 单例的实例在类加载的时候创建
 * 缺点 1.如果创建过程中进行很多的运算，会导致类加载的时候特别的慢
 *     2.如果创建出来的实例要很久以后才被调用，那么会导致资源的浪费
 * @author gaowenfeng
 * @date
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {
    /**
     * 私有构造函数
     */
    private SingletonExample2(){
        // 可能会进行很多操作，很多运算
    }

    /**
     * 单例对象
     */
    private static SingletonExample2 instance = new SingletonExample2();


    public static SingletonExample2 getInstance(){
        return instance;
    }
}

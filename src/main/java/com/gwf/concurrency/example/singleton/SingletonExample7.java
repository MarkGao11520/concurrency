package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候进行创建
 * 双实例同步锁实现模式
 * @author gaowenfeng
 * @date
 */
@Slf4j
@ThreadSafe
public class SingletonExample7 {
    /**
     * 私有构造函数
     */
    private SingletonExample7(){
        // 可能会进行很多操作，很多运算
    }

    /**
     * 单例对象
     */
    private static  SingletonExample7 instance = null;

    /**
     * 执行顺序很重要
     */
    static {
        instance = new SingletonExample7();
    }



    /**
     * 静态工厂模式
     */
    public static SingletonExample7 getInstance(){
        return instance;
    }
}

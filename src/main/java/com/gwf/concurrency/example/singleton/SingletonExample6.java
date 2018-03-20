package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.NotThreadSafe;
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
public class SingletonExample6 {
    /**
     * 私有构造函数
     */
    private SingletonExample6(){
        // 可能会进行很多操作，很多运算
    }

    /**
     * 单例对象 volatile + 双重检测机制->禁止指令重排
     */
    private static volatile SingletonExample6 instance = null;

    /**
     * 静态工厂模式
     */
    public static SingletonExample6 getInstance(){
        // 双重检测机制
        if (null == instance){
            // 同步锁
            synchronized (SingletonExample6.class){
                if(null == instance){
                    instance = new SingletonExample6();
                }
            }
        }
        return instance;
    }
}

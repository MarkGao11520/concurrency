package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候进行创建
 * @author gaowenfeng
 * @date
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {
    /**
     * 私有构造函数
     */
    private SingletonExample1(){
        // 可能会进行很多操作，很多运算
    }

    // 单例对象
    private static SingletonExample1 instance = null;

    /**
     * 静态工厂模式
     */
    public static SingletonExample1 getInstance(){
        if (null == instance){
            instance = new SingletonExample1();
        }
        return instance;
    }
}

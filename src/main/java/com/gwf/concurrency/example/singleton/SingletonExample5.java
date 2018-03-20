package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候进行创建
 * 双实例同步锁实现模式
 * @author gaowenfeng
 * @date
 */
@Slf4j
@NotThreadSafe
public class SingletonExample5 {
    /**
     * 私有构造函数
     */
    private SingletonExample5(){
        // 可能会进行很多操作，很多运算
    }

    /**
     * 单例对象
     */
    private static SingletonExample5 instance = null;

    /**
     * 静态工厂模式
     */
    public static SingletonExample5 getInstance(){
        // 双重检测机制
        if (null == instance){
            // 同步锁
            synchronized (SingletonExample5.class){
                if(null == instance){
                    // 1、memory = allocate() 分配对象的内存空间
                    // 2、ctorInstance() 初始化对象
                    // 3、instance = memory 设置instance指向刚分配的内存

                    // JVM 和 cpu优化，发生了指令重拍

                    // 1、memory = allocate() 分配对象的内存空间
                    // 3、instance = memory 设置instance指向刚分配的内存
                    // 2、ctorInstance() 初始化对象
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}

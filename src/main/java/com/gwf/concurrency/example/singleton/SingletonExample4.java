package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 改造后的饿汉模式-2
 * 单例的实例在类加载的时候创建
 * 利用了枚举在创建过程是线程安全的，并且JVM保证方法只被调用一次，但是这样写会暴露内部实现
 * 参考：https://www.jianshu.com/p/eb30a388c5fc?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * @author gaowenfeng
 * @date
 */
@Getter
@ThreadSafe
public enum  SingletonExample4 {
    INSTANCE;

    public void doSomething(){
        System.out.println("this is a test method to do something");
    }

}

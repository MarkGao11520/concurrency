package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 改造后的饿汉模式-1
 * 单例的实例在类加载的时候创建
 * 利用了ClassLoader来保证同步，同时又能让开发者控制类加载的时机，从内部看是一个饿汉式的单例，但是从内部看，又的确是懒汉式的实现
 * 参考：https://www.jianshu.com/p/eb30a388c5fc?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * @author gaowenfeng
 * @date
 */
@Slf4j
@ThreadSafe
public class SingletonExample3 {
    /**
     * 私有构造函数
     */
    private SingletonExample3(){
        // 可能会进行很多操作，很多运算
    }


    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample3 getInstance(){
        return SingletonHolder.singletonExample3;
    }

    /**
     * 由静态内部类创建单例对象
     */
    private static class SingletonHolder{
        private static final SingletonExample3 singletonExample3 = new SingletonExample3();
    }
}

package com.gwf.concurrency.example.singleton;

import com.gwf.concurrency.annoations.Recommend;
import com.gwf.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 改造后的饿汉模式-1
 * 枚举类型的单例，最安全最简单
 * 参考：https://www.jianshu.com/p/eb30a388c5fc?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * @author gaowenfeng
 * @date
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample8 {
    /**
     * 私有构造函数
     */
    private SingletonExample8(){
        // 可能会进行很多≠操作，很多运算
    }


    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample8 getInstance(){
        return Singleton.INSTANCE.getSingletonExample8();
    }

    /**
     * 由枚举类创建单例对象
     */
    @Getter
    private  enum  Singleton{
        INSTANCE;

        private SingletonExample8 singletonExample8;
        Singleton(){
            singletonExample8 = new SingletonExample8();
        }

    }
}

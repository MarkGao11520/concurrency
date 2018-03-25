package com.gwf.concurrency.example.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * request 处理器
 * @author gaowenfeng
 * @date 2018-03-20
 */
@Slf4j
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    /**
     * 添加数据
     * 在filter里将登录用户信息存入ThreadLocal
     * 如果不使用ThreadLocal，我们会需要将request一直透传
     * @param id
     */
    public static void add(Long id){
        // ThreadLocal 内部维护一个map，key为当前线程名，value为当前set的变量
        requestHolder.set(id);
    }

    /**
     * 获取数据
     * @return
     */
    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 移除变量信息
     * 如果不移除，那么变量不会释放掉，会造成内存泄漏
     * 在接口处理完以后进行处理（interceptor）
     */
    public static void remove(){
        requestHolder.remove();
    }
}

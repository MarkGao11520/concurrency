package com.gwf.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标示[线程安全的类]
 * @Target(ElementType.TYPE) 说明作用于类上
 * @Retention(RetentionPolicy.SOURCE) 指定注解作用的范围，在编译的时候就会被忽略掉
 * @author gaowenfeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}

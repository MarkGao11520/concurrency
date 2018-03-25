package com.gwf.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.gwf.concurrency.annoations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * @author gaowenfeng
 * @date
 */
@ThreadSafe
public class ImmutableExample1 {
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.util.Collections$UnmodifiableMap.put(Collections.java:1457)
        //	at com.gwf.concurrency.example.immutable.ImmutableExample1.main(ImmutableExample1.java:21)
        map.put(1,3);
    }

}

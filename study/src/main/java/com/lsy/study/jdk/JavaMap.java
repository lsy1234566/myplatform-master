package com.lsy.study.jdk;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.27
 */

public class JavaMap {

    @Test
    public void t1(){
        Map<String, Object> hashMap = new HashMap<>();
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap();
        hashMap.put("1231",1234);
        concurrentHashMap.put("1231",1234);
    }

    @Test
    public void t2(){

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1); //自动装箱
        ts.add(7);
        ts.add(3);
        ts.add(5);
        ts.add(3); //重复元素
        System.out.println(ts);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(4,4);
        treeMap.put(3,3);
        treeMap.put(5,5);
        treeMap.put(2,2);
        System.out.println(treeMap.toString());

    }
}

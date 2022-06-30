package com.lsy.study.jdk;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.26
 */

public class BaseJDK {


    @Test
    public void t1(){
        StringBuilder testBuilder = new StringBuilder("12345");
        StringBuffer testBuffer = new StringBuffer("12345");

        testBuilder.append("1341234");
        testBuilder.append("1341234");
        testBuilder.append("1341234");
    }

    @Test
    public void t2(){
        ArrayList<String> arrStr = new ArrayList<>();
        arrStr.add("13123121");
        arrStr.add("13123122");
        arrStr.add("13123123");
        arrStr.add("13123124");
        System.out.println(3>> 1);

        arrStr.add(2,"2");
        arrStr.add(3,"3");
        arrStr.remove(2);
        System.out.println(arrStr.get(2));
    }
}

package com.lsy.study.jdk;

import com.lsy.study.uitls.EnumSingleton;
import com.lsy.study.uitls.Singleton;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;

public class TestUnit {

    enum EnumSingleton {
        INSTANCE;
        private Integer singletonInt;
       EnumSingleton() {
            singletonInt = new Integer(11);
            System.out.println("init");
        }
        public Integer getInstnce(){
            return singletonInt;
        }

    }


    @Test
    public void t1(){
        Singleton.getInstance();
        System.out.println(EnumSingleton.INSTANCE.getInstnce());
    }

    @Test
    public void t2(){
        String key="1";
        int h;
        h = key.hashCode();
        System.out.println(h);
        int i = h >>> 16;
        System.out.println(i);
        System.out.println(h^i);
    }

}

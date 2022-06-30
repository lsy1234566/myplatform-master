package com.lsy.myplatform;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.19
 */

public class ThreadTest {

    volatile boolean flag=true;
    @Test
    public void t1(){
        Thread thread = new Thread(() -> {
            System.out.println("111");
            while (flag){
            }
        });

        thread.start();
        //关闭方式
        flag=false;
        thread.interrupt();
        thread.stop();
    }
    @Test
    public void t2(){
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        Set<String> objects = objectObjectHashMap.keySet();
        objectObjectHashMap.forEach((k,v)->{ });
        Iterator<String> iterator = objects.iterator();
    }

    @Test
    public void t3() throws InterruptedException {
        //-XX:-PrintGCDetails
        LinkedList<Object> objects = new LinkedList<>();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();


        TimeUnit.SECONDS.sleep(10);
        System.gc();
        Runtime.getRuntime().gc();
        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void t4() throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(()->{
            synchronized (ThreadTest.class){
                System.out.println("static class");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        TimeUnit.SECONDS.sleep(1);
        executorService.submit(()->{
            synchronized (threadTest){
                System.out.println("class");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        TimeUnit.SECONDS.sleep(100);
    }
}

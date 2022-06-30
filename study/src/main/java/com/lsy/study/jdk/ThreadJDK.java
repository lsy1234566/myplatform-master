package com.lsy.study.jdk;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.26
 */

public class ThreadJDK {

    @Test
    public void t1(){
        Thread thread = new Thread(() -> {
            System.out.println("1234123");
        });
        thread.start();
        //申请
        //执行 private native void start0();
    }

    @Test
    public void t2() throws ExecutionException, InterruptedException {
        //Manually create thread pool is better.
        Executors.newScheduledThreadPool(2);;//args-int 线程无上限，线程可能会很多，导致OOM
        Executors.newCachedThreadPool();//0-int 线程无上限，线程可能会很多，导致OOM
        Executors.newFixedThreadPool(5); //线程数量固定,任务队列容易堆积,导致OOM
        Executors.newSingleThreadExecutor();//线程数量固定,任务队列容易堆积,导致OOM


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, Executors.privilegedThreadFactory());

        int coreSize = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),Executors.privilegedThreadFactory());
        Future<Integer> submit = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1000;
            }
        });
        threadPoolExecutor.execute(()->{

        });
         threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws InterruptedException {
                System.out.println(Thread.currentThread().getName());
                System.out.println("1000");
                TimeUnit.SECONDS.sleep(1);
                return 1000;
            }
        });
        threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println(Thread.currentThread().getName());
                return 1000;
            }
        });
        threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println(Thread.currentThread().getName());
                return 1000;
            }
        });
        threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println(Thread.currentThread().getName());
                return 1000;
            }
        });

        TimeUnit.SECONDS.sleep(40);
    }

    @Test
    public  void t3(){
//        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
//
//        stringThreadLocal.set("11");
//        System.out.println(stringThreadLocal.get());

//        int i=6;
//        //421
//        System.out.println(i>>=1);
//        System.out.println(1 & ~2);

        retry:
        for (;;){
            System.out.println("1");
            for (;;){
                System.out.println("2");
                break retry;
            }
        }
        System.out.println("3");
    }



}

package com.lsy.study.uitls;

public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){
        System.out.println(":");
    }
    public static final Singleton getInstance() {
        System.out.println(":");
        return SingletonHolder.INSTANCE;
    }


}

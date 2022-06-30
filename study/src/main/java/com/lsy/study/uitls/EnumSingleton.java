package com.lsy.study.uitls;

public enum EnumSingleton {
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

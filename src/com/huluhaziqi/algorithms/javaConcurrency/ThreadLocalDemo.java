package com.huluhaziqi.algorithms.javaConcurrency;

public class ThreadLocalDemo{
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("main");
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocal.set("test1");

                System.out.println(threadLocal.get());
            }
        };
        thread.start();

        System.out.println(threadLocal.get());


    }
}

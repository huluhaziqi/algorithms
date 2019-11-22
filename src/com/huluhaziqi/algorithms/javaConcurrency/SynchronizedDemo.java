package com.huluhaziqi.algorithms.javaConcurrency;

public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class){
            System.out.println("synchronized");
        }
        method();
    }

    private static void method(){
        System.out.println("this is method ");
    }

}

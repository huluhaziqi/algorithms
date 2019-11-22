package com.huluhaziqi.algorithms.javaConcurrency;



import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args) {
        Executor  executor = Executors.newSingleThreadExecutor();
    }
}

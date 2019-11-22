package com.huluhaziqi.algorithms.javaConcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.callable(new Runnable() {
            @Override
            public void run() {
                System.out.println("ddd");
            }
        });
    }
}

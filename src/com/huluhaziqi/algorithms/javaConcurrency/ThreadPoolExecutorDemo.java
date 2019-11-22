package com.huluhaziqi.algorithms.javaConcurrency;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("IndexService-pool-%d").build();
        ThreadPoolExecutor t = new ThreadPoolExecutor(10,
                50,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(1024), Executors.defaultThreadFactory());
    }
}

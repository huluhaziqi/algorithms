package com.huluhaziqi.algorithms.javaConcurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwinsLockTest {
    public static void main(String[] args) {
        new TwinsLockTest().test();
    }

    public void test() {
        final Lock lock = new TwinsLock();
        final Lock reetrantLock = new ReentrantLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            System.out.println(Thread.currentThread().getName());
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        try {
            // Æô¶¯10¸öÏß³Ì
            for (int i = 0; i < 10; i++) {
                Worker w = new Worker();
                w.setDaemon(true);
                w.start();
            }
            // Ã¿¸ô1Ãë»»ÐÐ
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


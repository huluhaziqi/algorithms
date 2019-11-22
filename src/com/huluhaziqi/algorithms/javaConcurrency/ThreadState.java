package com.huluhaziqi.algorithms.javaConcurrency;

public class ThreadState {

    public static void main(String[] args) {
        Thread timeWaiting = new TimeWaiting();
        timeWaiting.setName("timeWaiting");
        Thread waiting = new Waiting();
        waiting.setName("waiting");
        Thread bloaked1 = new Blocked();
        bloaked1.setName("blocked1");
        Thread bloaked2 = new Blocked();
        bloaked2.setName("blocked2");
        timeWaiting.start();
        waiting.start();
        bloaked1.start();
        bloaked2.start();
    }

    static class TimeWaiting extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked extends Thread {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

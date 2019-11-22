package com.huluhaziqi.algorithms.javaConcurrency;

public class InterruptDemo {

    public static void main(String[] args) {
        Thread sleeppDemo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        sleeppDemo.start();


        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) ;
            }
        };
        busyThread.start();

        sleeppDemo.interrupt();
        busyThread.interrupt();
        System.out.println(sleeppDemo.isInterrupted() + " " + busyThread.isInterrupted());

    }
}

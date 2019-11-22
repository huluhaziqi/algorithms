package com.huluhaziqi.algorithms.pattern.bridge;

public class TV1 extends TV {
    @Override
    public void on() {
        System.out.println("tv1 on");
    }

    @Override
    public void off() {
        System.out.println("tv1 off");

    }

    @Override
    public void tuneChannel() {
        System.out.println("tv1 tuneChannel");

    }
}

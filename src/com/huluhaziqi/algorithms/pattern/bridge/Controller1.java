package com.huluhaziqi.algorithms.pattern.bridge;

public class Controller1 extends RemoteController {

    public Controller1(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("controller1 on");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("controller1 off");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("controller1 tuneChannel");
        tv.tuneChannel();
    }
}

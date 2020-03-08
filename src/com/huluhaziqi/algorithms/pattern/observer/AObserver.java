package com.huluhaziqi.algorithms.pattern.observer;

public class AObserver implements Observer {
    @Override
    public void update(int temperture, int humidity, int pressure) {
        System.out.println(temperture + " " + humidity + " " + pressure);
    }

    public AObserver(Subject subject) {
        subject.registerObserver(this);
    }
}

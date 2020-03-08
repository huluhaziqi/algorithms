package com.huluhaziqi.algorithms.pattern.observer;

public class ConcreteObsrever implements Observer {

    public ConcreteObsrever(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(int temperture, int humidity, int pressure) {
        System.out.println("ConcreteObsrever " + temperture + " " + humidity + " " + pressure);
    }
}

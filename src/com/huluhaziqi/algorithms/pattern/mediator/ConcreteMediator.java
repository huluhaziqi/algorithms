package com.huluhaziqi.algorithms.pattern.mediator;

public class ConcreteMediator extends Mediator {

    private A a;
    private B b;

    public ConcreteMediator(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void doEvent(String eventType) {
        switch (eventType) {
            case "a":
                doA();
                break;
            case "b":
                doB();
                break;
            default:
                break;
        }
    }

    public void doA() {
        a.doA();
    }

    public void doB() {
        b.doB();
    }

}

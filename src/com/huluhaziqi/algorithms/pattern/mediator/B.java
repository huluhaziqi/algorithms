package com.huluhaziqi.algorithms.pattern.mediator;

public class B extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("b");
    }

    public void doB(){
        System.out.println("doB");
    }
}

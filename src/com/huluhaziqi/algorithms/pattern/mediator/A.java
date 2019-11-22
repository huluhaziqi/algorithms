package com.huluhaziqi.algorithms.pattern.mediator;

public class A extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("a");
    }

    public void doA(){
        System.out.println("doA ");
    }
}

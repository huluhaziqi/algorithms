package com.huluhaziqi.algorithms.pattern.mediator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Mediator mediator = new ConcreteMediator(a, b);
        a.onEvent(mediator);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}

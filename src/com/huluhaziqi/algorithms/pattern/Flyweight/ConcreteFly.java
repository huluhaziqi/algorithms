package com.huluhaziqi.algorithms.pattern.Flyweight;

public class ConcreteFly implements Flyweight {

    String in;

    public ConcreteFly(String in) {
        this.in = in;
    }

    @Override
    public void operator(String ext) {
        System.out.println("address :" + System.identityHashCode(this));
        System.out.println("in:" + in);
        System.out.println("ext:" + ext);
    }
}

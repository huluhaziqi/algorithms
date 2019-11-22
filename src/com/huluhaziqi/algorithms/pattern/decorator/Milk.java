package com.huluhaziqi.algorithms.pattern.decorator;

public class Milk extends Decorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}

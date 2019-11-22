package com.huluhaziqi.algorithms.pattern.decorator;

public class Mocha extends Decorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 4 + beverage.cost();
    }
}

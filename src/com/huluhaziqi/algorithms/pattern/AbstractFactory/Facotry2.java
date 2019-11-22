package com.huluhaziqi.algorithms.pattern.AbstractFactory;

public class Facotry2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}

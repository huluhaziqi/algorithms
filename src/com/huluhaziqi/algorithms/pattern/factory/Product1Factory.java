package com.huluhaziqi.algorithms.pattern.factory;

public class Product1Factory extends Factory {

    @Override
    public Product factoryMethod() {
        return new Product1();
    }
}

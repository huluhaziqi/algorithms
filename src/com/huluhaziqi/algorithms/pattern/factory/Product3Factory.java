package com.huluhaziqi.algorithms.pattern.factory;

public class Product3Factory extends Factory {

    @Override
    public Product factoryMethod(){
        return new Product3();
    }
}

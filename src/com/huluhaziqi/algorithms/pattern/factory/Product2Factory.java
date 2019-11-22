package com.huluhaziqi.algorithms.pattern.factory;

public class Product2Factory extends Factory {

    @Override
    public Product factoryMethod(){
        return new Product2();
    }
}

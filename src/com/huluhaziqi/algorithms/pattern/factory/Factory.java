package com.huluhaziqi.algorithms.pattern.factory;

abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething(){
        Product product = factoryMethod();
    }
}

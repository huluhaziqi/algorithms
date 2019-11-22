package com.huluhaziqi.algorithms.pattern.TemplateMethod;

public class CaffeBeverage extends Beverage{

    @Override
    void brew() {
        System.out.println("caffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("cafee.addCondiments");
    }
}

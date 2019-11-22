package com.huluhaziqi.algorithms.pattern.TemplateMethod;

public class Tea extends Beverage {

    @Override
    void brew() {
        System.out.println("tea.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("tea.addCondiments");
    }
}

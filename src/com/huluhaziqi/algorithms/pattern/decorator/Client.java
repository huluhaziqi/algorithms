package com.huluhaziqi.algorithms.pattern.decorator;

public class Client {

    public static void main(String[] args) {
        //装饰者（Decorator）和具体组件（ConcreteComponent）都继承自组件（Component
        //装饰者组合了一个组件，可以装饰其他装饰者或者组件
        DarkRoast darkRoast = new DarkRoast();
        HouseBlend houseBlend = new HouseBlend();
        Milk milk = new Milk(darkRoast);
        System.out.println(milk.cost());
        Mocha mocha = new Mocha(houseBlend);
        System.out.println(mocha.cost());
    }
}

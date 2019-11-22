package com.huluhaziqi.algorithms.pattern.Flyweight;

public class Client {
    public static void main(String[] args) {
        //有一些对象内部状态是相同的，
        Factory factory = new Factory();
        Flyweight flyweight1 = factory.get("aa");
        Flyweight flyweight2 = factory.get("aa");
        flyweight1.operator("x");
        flyweight1.operator("y");
    }
}

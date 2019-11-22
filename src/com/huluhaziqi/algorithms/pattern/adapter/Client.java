package com.huluhaziqi.algorithms.pattern.adapter;

public class Client {

    public static void main(String[] args) {
        WildTurkey turkey = new WildTurkey();
        TurkeyAdapter adapter = new TurkeyAdapter(turkey);
        Duck duck = adapter;
        duck.quack();
    }
}

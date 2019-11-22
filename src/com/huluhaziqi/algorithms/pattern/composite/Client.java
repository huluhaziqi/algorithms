package com.huluhaziqi.algorithms.pattern.composite;

public class Client {

    public static void main(String[] args) {
        //组合模式
        //可以
        Coposite coposite = new Coposite("coposite");
        coposite.add(new Coposite("A"));
        coposite.add(new Coposite("B"));
        coposite.add(new Leaf("LEAF1"));
        coposite.print(9);
    }
}

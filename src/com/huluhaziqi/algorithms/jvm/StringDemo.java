package com.huluhaziqi.algorithms.jvm;

public class StringDemo {

    public static void main(String[] args) {
        String test1  = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(test1.intern() == test1);

        String test2  = new StringBuilder().append("ja").append("va").toString();
        System.out.println(test2.intern() == test2);
    }
}

package com.huluhaziqi.algorithms.pattern.Null;

public class Client {
    public static void main(String[] args) {
        AbstractOperation abstractOperation = func(-1);
        abstractOperation.request();
        AbstractOperation abstractOperation1 = func(2);
        abstractOperation1.request();
    }

    public static AbstractOperation func(int p){
        if(p < 0){
            return new NullOperation();
        } else {
            return new RealOperation();
        }
    }
}

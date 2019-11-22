package com.huluhaziqi.algorithms.pattern.single;

public class Single2 {

    private static volatile Single2 single2;

    private Single2() {

    }

    public static Single2 getSingle2() {
        if (single2 == null) {
            synchronized (Single2.class) {
                if (single2 == null) {
                    single2 = new Single2();
                }
            }
        }
        return single2;
    }
}

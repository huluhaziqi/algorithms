package com.huluhaziqi.algorithms.pattern.single;

public class Single {
    private static final Single single = new Single();

    private Single() {

    }

    public static Single getSingle() {
        return single;
    }
}

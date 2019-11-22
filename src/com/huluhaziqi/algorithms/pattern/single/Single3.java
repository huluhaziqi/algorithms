package com.huluhaziqi.algorithms.pattern.single;

public enum Single3 {
    A,
    B;
    private Resource resource;

    Single3() {
        resource = new Resource();
    }

    public Resource getValue() {
        return resource;
    }
}

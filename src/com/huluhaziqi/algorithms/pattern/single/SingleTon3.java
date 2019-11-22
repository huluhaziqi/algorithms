package com.huluhaziqi.algorithms.pattern.single;

public enum SingleTon3 {
    A,
    B;

    private Resource resource;

    SingleTon3() {
        resource = new Resource();
    }

    public Resource getValue() {
        return resource;
    }
}

class Resource{
    public Resource() {
        System.out.println("fdsds" + Thread.currentThread().getName());
    }
}

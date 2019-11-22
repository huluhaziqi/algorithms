package com.huluhaziqi.algorithms.pattern.iterator;


public class ConcreateAggregate implements Aggregate {

    private Integer[] item;

    public ConcreateAggregate() {
        item = new Integer[10];
        for (int i = 0; i < item.length; i++) {
            this.item[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<Integer>(item);
    }
}

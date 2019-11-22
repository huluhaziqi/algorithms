package com.huluhaziqi.algorithms.pattern.visitor;


public interface Visitor {

    void visit(Customer customer);

    void visit(Item item);

    void visit(Order order);
}

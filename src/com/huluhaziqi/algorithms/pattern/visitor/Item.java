package com.huluhaziqi.algorithms.pattern.visitor;

public class Item implements Element {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void acctpt(Visitor visitor) {
        visitor.visit(this);
    }
}

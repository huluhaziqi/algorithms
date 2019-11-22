package com.huluhaziqi.algorithms.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Element {

    private String name;

    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void acctpt(Visitor visitor) {
        visitor.visit(this);
        for (Order order : orders) {
            order.acctpt(visitor);
        }
    }
}

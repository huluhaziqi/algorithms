package com.huluhaziqi.algorithms.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class CustomerGroup {

    private String name;

    private List<Customer> customerList = new ArrayList<>();

    public CustomerGroup(String name) {
        this.name = name;
    }

    public void accept(Visitor visitor) {
        for (Customer customer : customerList) {
            customer.acctpt(visitor);
        }
    }

    void addCustomer(Customer c) {
        customerList.add(c);
    }
}

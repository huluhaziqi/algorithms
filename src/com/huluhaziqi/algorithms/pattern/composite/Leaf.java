package com.huluhaziqi.algorithms.pattern.composite;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    void print(int level) {
        System.out.println("leaf :" + name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();

    }
}

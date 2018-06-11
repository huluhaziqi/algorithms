package lin.java.test.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Order implements Element {

    private String name;

    private List<Item> items = new ArrayList<>();

    public Order(String name) {
        this.name = name;
    }

    public Order(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Order(String name, String itemName) {
        this.name = name;
        this.addItem(new Item(itemName));
    }


    public void addItem(Item item) {
        items.add(item);
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
        for (Item item : items) {
            item.acctpt(visitor);
        }
    }
}

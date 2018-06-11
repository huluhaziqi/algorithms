package lin.java.test.pattern.visitor;

public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer("customer1");
        customer.addOrder(new Order("order1","item1"));
        customer.addOrder(new Order("order1","item2"));
        customer.addOrder(new Order("order1","item3"));
        customer.addOrder(new Order("order2","item1"));
        customer.addOrder(new Order("order2","item2"));
        customer.addOrder(new Order("order2","item3"));

        Order order = new Order("order2");
        order.addItem(new Item("1"));
        order.addItem(new Item("2"));
        order.addItem(new Item("3"));
        Customer customer1 = new Customer("customer2");
        customer1.addOrder(order);

        GeneralReport visitor = new GeneralReport();
        CustomerGroup group = new CustomerGroup("group");
        group.addCustomer(customer);
        group.addCustomer(customer1);
        group.accept(visitor);

        visitor.display();
    }
}

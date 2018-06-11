package lin.java.test.pattern.visitor;


public interface Visitor {

    void visit(Customer customer);

    void visit(Item item);

    void visit(Order order);
}

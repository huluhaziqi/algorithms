package lin.java.test.pattern.visitor;

public class GeneralReport implements Visitor {

    private int customerNo;

    private int orderNo;

    private int itemNo;

    @Override
    public void visit(Customer customer) {
        System.out.println(customer.getName());
        customerNo++;
    }

    @Override
    public void visit(Item item) {
        System.out.println(item.getName());
        itemNo++;
    }

    @Override
    public void visit(Order order) {
        System.out.println(order.getName());
        orderNo++;
    }

    public void display(){
        System.out.println("customerNo :" + customerNo);
        System.out.println("orderNo :" + orderNo);
        System.out.println("itemNo :" + itemNo);
    }
}

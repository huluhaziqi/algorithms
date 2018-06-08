package lin.java.test.pattern.iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreateAggregate();
        Iterator<Integer> integerIterator= aggregate.createIterator();
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
    }
}

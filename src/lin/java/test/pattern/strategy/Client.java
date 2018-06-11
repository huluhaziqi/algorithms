package lin.java.test.pattern.strategy;

public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Quack());
        duck.quack();
        duck.setQuackBehavior(new Squeak());
        duck.quack();
    }
}

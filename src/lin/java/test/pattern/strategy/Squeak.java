package lin.java.test.pattern.strategy;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}

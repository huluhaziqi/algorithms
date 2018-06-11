package lin.java.test.pattern.strategy;

public class Duck {
    private QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void quack(){
        if(quackBehavior != null){
            quackBehavior.quack();
        }
    }
}

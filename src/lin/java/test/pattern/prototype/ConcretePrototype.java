package lin.java.test.pattern.prototype;

public class ConcretePrototype extends Prototype {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(this.filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}

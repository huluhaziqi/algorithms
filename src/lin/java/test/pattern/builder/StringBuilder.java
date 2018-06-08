package lin.java.test.pattern.builder;

public class StringBuilder extends AbstractStringBuilder {

    public StringBuilder(int capacity) {
        super(capacity);
    }

    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value,0,count);
    }
}

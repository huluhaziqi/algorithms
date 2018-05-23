package lin.java.test.pattern;

public class SingleTon {

    private SingleTon instance;

    public SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}

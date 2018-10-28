package lin.java.test.pattern.single;

public class SingleTon {

    private static SingleTon instance;

    //懒汉模式
    public synchronized SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }

}



package lin.java.test.pattern.single;

public class SingleTon1 {

    private static volatile SingleTon1 instance;

    public SingleTon1 getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new SingleTon1();
                    //1、分配空间
                    //2、初始化对象
                    //3、地址指向
                    //2和3会重排序，volatile禁止重排序的发生。
                }
            }
        }
        return instance;
    }
}

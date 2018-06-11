package lin.java.test.pattern.facade;

public class Client {

    public static void main(String[] args) {
        //包装子系统，统一对外入口
        Facade facade = new Facade();
        facade.watchMovie();
    }
}

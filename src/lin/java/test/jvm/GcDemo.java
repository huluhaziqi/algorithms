package lin.java.test.jvm;

public class GcDemo {
    public Object instance = null;

    public static void main(String[] args) {
        f();
        System.gc();
    }

    public static int count = 0;

    public static void f() {
        count++;
        System.out.println(count);
        f();
    }
}

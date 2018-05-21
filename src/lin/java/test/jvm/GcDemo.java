package lin.java.test.jvm;

public class GcDemo {
    public Object instance = null;

    public static void main(String[] args) {
        GcDemo objA = new GcDemo();
        GcDemo objB = new GcDemo();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }
}

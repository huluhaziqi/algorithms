package lin.java.test.test;

public class HelloWorld {
    public static void main(String[] args) {
        ClassLoader classLoader = HelloWorld.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        try {
            classLoader.loadClass("lin.java.test.test.Test01");
            Class.forName("lin.java.test.test.Test01");
            Class.forName("lin.java.test.test.Test01",false,classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

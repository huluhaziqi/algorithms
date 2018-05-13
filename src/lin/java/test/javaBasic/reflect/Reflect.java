package lin.java.test.javaBasic.reflect;

public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        String s = "aaaa";
        Class cls1 = s.getClass();
        Class cls2 = String.class;
        Class cls3 = Class.forName("java.lang.String");
        if(cls1 == cls2) {
            System.out.println(true);
        }
        if(cls3 == cls2) {
            System.out.println(true);
        }
    }
}

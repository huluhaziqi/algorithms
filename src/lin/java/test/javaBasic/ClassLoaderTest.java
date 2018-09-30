package lin.java.test.javaBasic;

import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class clc = classLoader.loadClass("lin.java.test.javaBasic.reflect.Reflect");
            Object reflect = clc.newInstance();
            Class[] params = new Class[1];
            params[0] = String[].class;
            Method mainMethod = clc.getMethod("main",String[].class);
            System.out.println(mainMethod.getName());
            Object[] arg = new Object[1];
            arg[0]= new String[]{"fsssfdd"};
            mainMethod.invoke(reflect,arg[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e1){
            e1.printStackTrace();
        }

        try {
            Class clc2 = Class.forName("in.java.test.javaBasic.reflect");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package lin.java.test.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UserInfoTest {
    public static void main(String[] args) {
        try {
            UserInfo userInfo = new UserInfo();

            Class cls1 = Class.forName("lin.java.test.test.UserInfo");
            Class cls2 = lin.java.test.test.UserInfo.class;
            Class cls3 = userInfo.getClass();
            System.out.println(cls1.getName());
            System.out.println(cls1.getSimpleName());
            Field[] fields = cls1.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            Field[] fields1 = cls1.getDeclaredFields();
            for (Field field : fields1) {
                System.out.println(field.getModifiers());
                System.out.println(field.getName());
                System.out.println(field.getType());

            }
            System.out.println("-----");
            cls1.getDeclaredConstructors();
            Method[] methods = cls1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println( method.getName() + " " + method.getReturnType());
                Class[] classes =  method.getParameterTypes();
                for (Class aClass : classes) {
                    System.out.println(aClass.getName());
                }
            }
            try {
                UserInfo userInfo1 = (UserInfo)cls1.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

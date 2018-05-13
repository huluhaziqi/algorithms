package lin.java.test.javaBasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserInfoReflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class mclass = Class.forName("lin.java.test.javaBasic.reflect.UserInfo");
        System.out.println(mclass.getName());
        System.out.println(mclass.getSimpleName());

        System.out.println("属性");
        Field[] fields = mclass.getFields();
        for (Field field : fields) {
            System.out.println(" " + field.getModifiers() + " " + field.getType() + " " + field.getName());
        }

        Field[] declaredFields = mclass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getModifiers() + " " + field.getType() + " " + field.getName());
        }

        System.out.println("方法");
        Method[] methods = mclass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getModifiers() + " " + method.getReturnType());
            Class[] params = method.getParameterTypes();
            for (Class param : params) {
                System.out.println(param.getName());
            }
        }

        System.out.println("construct");
        Constructor[] constructors = mclass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getModifiers() + " " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println(param.getName());
            }
        }

        System.out.println("反射执行方法");
        String name = "myInfo";
        Class[] params = new Class[3];
        params[0] = String.class;
        params[1] = Integer.class;
        params[2] = String.class;
        Method m = mclass.getDeclaredMethod(name, params);
        Object object = mclass.newInstance();
        Object[] arg = new Object[3];
        arg[0] = "fdsfsd";
        arg[1] = new Integer(23);
        arg[2] = "high";
        m.invoke(object, arg);
    }
}

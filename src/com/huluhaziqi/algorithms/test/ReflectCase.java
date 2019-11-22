package com.huluhaziqi.algorithms.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectCase {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Class c = proxy.getClass();
        try {
            Method method = c.getDeclaredMethod("run");
            method.invoke(proxy);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static class Proxy{
        public void run(){
            System.out.println("run this ");
        }

    }
}

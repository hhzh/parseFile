package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectDemo {
    public static void main(String[] args) {
        Class<Demo> demoClass = Demo.class;
        //Constructor<?>[] declaredConstructors = demoClass.getDeclaredConstructors();
        //for (Constructor<?> declaredConstructor : declaredConstructors) {
        //    System.out.println(declaredConstructor);
        //}
        //try {
        //    Constructor<Demo> declaredConstructor = demoClass.getDeclaredConstructor(String.class);
        //    System.out.println(declaredConstructor);
        //    declaredConstructor.setAccessible(true);
        //    Demo name = declaredConstructor.newInstance("name");
        //
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        try {
            Method declaredMethod = demoClass.getDeclaredMethod("world",String.class);
            System.out.println(declaredMethod);
            Demo demo = demoClass.getConstructor().newInstance();
            declaredMethod.invoke(demo, "999");
            ClassLoader classLoader = demo.getClass().getClassLoader();
            //Proxy.newProxyInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

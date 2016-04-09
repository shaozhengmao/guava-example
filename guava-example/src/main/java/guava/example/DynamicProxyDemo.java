/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.google.common.reflect.Reflection;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月29日下午11:56:53
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInvocationHandler();

        // Guava Dynamic Proxy implement
        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
        foo.doSomething();
        // jdk Dynamic proxy implement
        IFoo jdkFoo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[] {IFoo.class},
                invocationHandler);
        jdkFoo.doSomething();
    }

    public static class MyInvocationHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("proxy println something");
            return null;
        }
    }

    public static interface IFoo {
        void doSomething();
    }
}

package com.cristik.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhenghua on 2016/3/10.
 */
public class DynamicProxyTest {
	static interface IHello {
		public String sayHello();
	}

	static class DynaProxy implements InvocationHandler {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("dynamic proxy");
			return new String("123");
		}
	}

	public static void main(String[] args) {
		IHello hello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[] { IHello.class }, new DynaProxy());
		String str = hello.sayHello();
		System.out.println(str);
	}
}

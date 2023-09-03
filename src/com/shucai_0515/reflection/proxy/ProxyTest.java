package com.shucai_0515.reflection.proxy;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理
 */
public class ProxyTest {

    @Test
    public void staticProxy(){
        //编译期能确定代理类，为静态代理
        UserService UserServiceImpl_StaticProxy = new UserServiceImpl_StaticProxy();
        UserServiceImpl_StaticProxy.doHandle();
        //static dynamicProxy enhance >...
        //do handle >...
    }

    @Test
    public void dynamicProxy() {
        UserService userService = new UserServiceImpl();
        UserServiceImpl_DynamicProxy proxy = new UserServiceImpl_DynamicProxy();
        UserService o = (UserService) proxy.get(userService);
        o.doHandle();
        //enhance by dynamic proxy
        //do handle >...
    }

}
interface UserService {
    void doHandle();
}

class UserServiceImpl implements UserService {

    @Override
    public void doHandle() {
        System.out.println("do handle >...");
    }
}

class UserServiceImpl_StaticProxy implements UserService{

    private UserService userService = new UserServiceImpl();

    @Override
    public void doHandle() {
        //enhance
        System.out.println("static dynamicProxy enhance >...");
        userService.doHandle();
    }
}

class UserServiceImpl_DynamicProxy implements InvocationHandler {
    private Object target;

    public Object get(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this );
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        //enhanced logic
        System.out.println("enhance by dynamic proxy");
        return method.invoke(this.target, args);
    }
}
package com.shucai.factory;

import com.shucai.utils.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component("proxyFactory")
public class ProxyFactory {

    @Autowired
    private TransactionManager transactionManager;

    /**
     * jdk
     */
    public Object getJdkProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object res = null;
                        try {
                            // begin transaction
                            transactionManager.beginTransaction();
                            method.invoke(obj, args);
                            // commit transaction
                            transactionManager.commitTransaction();
                        } catch (Exception e) {
                            transactionManager.rollbackTransaction();
                            throw e;
                        }
                        return res;
                    }
                });
    }

    /**
     * cglib
     */
    public Object getCglibProxy(Object obj) {
        return Enhancer.create(obj.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object res = null;
                        try {
                            // begin transaction
                            transactionManager.beginTransaction();
                            res = method.invoke(obj, objects);
                            // commit transaction
                            transactionManager.commitTransaction();
                        } catch (Exception e) {
                            transactionManager.rollbackTransaction();
                            throw e;
                        }
                        return res;
                    }
                });
    }
}

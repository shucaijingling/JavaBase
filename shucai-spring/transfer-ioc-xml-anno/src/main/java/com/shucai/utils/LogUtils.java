package com.shucai.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogUtils {

    // before
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("AOP ...before-----start");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("AOP ...before------done");
    }

    // end
    public void afterMethod() {
        System.out.println("AOP end ...");
    }

    // exception
    public void exceptionMethod() {
        System.out.println("aop ... exception");
    }

    // normal
    public void successMethod() {
        System.out.println("normal success...");
    }


    public Object  aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("around start...");
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("around exception...");
        }finally {
            System.out.println("around finally ...");
        }
        System.out.println("around end...");
        return proceed;
    }

}

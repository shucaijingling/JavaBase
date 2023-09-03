package com.shucai.proxy2;

public class ProxyTest {
    public static void main(String[] args) {
        Principal principal = new Principal();
        Agent agent = new Agent(principal);
        agent.method1();
        agent.method2();
        agent.method3();
        agent.method4();
        agent.method5();
        agent.method6();
    }
}
//需要被代理的行为
interface Behavior {
    void method1();
    void method2();
    void method3();
    void method4();
    void method5();
    void method6();

}
//被代理类
class Principal implements Behavior {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {
        System.out.println("do one method:::: method4");
    }

    @Override
    public void method5() {

    }

    @Override
    public void method6() {

    }
}

//代理类
class Agent implements Behavior {

    private Behavior behavior;

    public Agent(Behavior behavior) {
        this.behavior = behavior;
    }

    //代理人独有的方法
    public void agentMethod() {
        System.out.println("agent do something");
    }

    @Override
    public void method1() {
        System.out.println("dynamicProxy method1");
        agentMethod();
    }

    @Override
    public void method2() {
        System.out.println("dynamicProxy method2");
    }

    @Override
    public void method3() {
        System.out.println("dynamicProxy method3");
    }

    //被代理人完成的方法
    @Override
    public void method4() {
        behavior.method4();
    }

    @Override
    public void method5() {
        System.out.println("dynamicProxy method5");
    }

    @Override
    public void method6() {
        System.out.println("dynamicProxy method6");
    }

}
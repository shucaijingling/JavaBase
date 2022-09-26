package com.atguigu.wrong;

public class WrongTest {
    public static void main(String[] args) {
        C c = new C();
        c.method();
    }
}
interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    void method() {
//        System.out.println(x); 错误
        System.out.println(super.x); //1
        System.out.println(A.x); //0
    }
}

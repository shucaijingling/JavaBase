package com.shucai.inner;

public class InnerClassTest {
    public static void main(String[] args) {
        //创建Dog实例（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
        System.out.println(2);
        bird.display("arge");
    }
}
class Person {

    String name = "Person";
    int age;
    public void eat() {
        System.out.println("eat eat eat");
    }
    //静态成员内部类
    static class Dog {
        String name;
        int age;
        public void show() {
            System.out.println("show show show");
//            eat(); 静态无法调用非静态
        }
    }
    //非静态成员内部类
    class Bird {
        String name = "bird";

        public Bird() {

        }
        public void sing() {
            System.out.println("sing sing sing ");
            Person.this.eat();//调用外部类的属性（非静态）
        }

        public void display(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    public void method() {
        //局部内部类
        class AA {

        }
    }
}

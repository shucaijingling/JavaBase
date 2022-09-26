package com.atguigu.block;

import java.util.concurrent.atomic.DoubleAdder;


class Root {
    static {
        System.out.println("Root static block");
    }
    {
        System.out.println("Root block");
    }
    public Root() {
        System.out.println("Root no arg Construct");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid static block");
    }
    {
        System.out.println("Mid block");
    }
    public Mid() {
        System.out.println("Mid no arg Construct");
    }

    public Mid(String msg) {
        //调用无参构造
        this();
        System.out.println("Mid Construct with args : " + msg);
    }

}

class Leaf extends Mid {
    static {
        System.out.println("Leaf static block");
    }
    {
        System.out.println("Leaf block");
    }

    public Leaf() {
        //调用父类有参构造
        super("Leaf call parent class with parameter");
        System.out.println("leaf Construct");
    }
}
public class LeafTest {
    public static void main(String[] args) {
        //create an Leaf object
        new Leaf();

        final String name = "AAA";
    }
}



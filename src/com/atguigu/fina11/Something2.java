package com.atguigu.fina11;

public class Something2 {
    public static void main(String[] args) {
        Other other = new Other();
        new Something2().addOne(other);
    }
    public void addOne(final Other o){
//        o = new Other(); //编译错误
        o.i++; //o中的属性可以变化
    }
}
class Other {
    public int i;
}


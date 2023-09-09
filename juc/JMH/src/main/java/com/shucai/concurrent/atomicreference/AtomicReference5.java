package com.shucai.concurrent.atomicreference;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题，使用增加版本号【乐观锁方式】AtomicStampedReference
 */
public class AtomicReference5 {


    public static void main(String[] args) {

        AtomicStampedReference<String> reference = new AtomicStampedReference<>("Hello", 1);

        assert reference.getReference().equals("Hello"):"value is not match";

        assert reference.getStamp() == 1:"version is error";

        int[] holder = new int[1];
        String value = reference.get(holder);
        assert value.equals("Hello");
        assert holder[0] == 1;

        assert !reference.compareAndSet("Hello", "World", 2, 3) : "update failed";

        assert reference.compareAndSet("Hello", "World", 1, 2);

        assert reference.getReference().equals("World");

        //直接设置新的引用值以及stamp
        reference.set("Hello, World", reference.getStamp() + 1);
        assert reference.getReference().equals("Hello, World");


        reference.set("Hello, World", 90);
        assert reference.getReference().equals("Hello, World");
        assert reference.getStamp() == 90;
    }

}

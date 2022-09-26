package com.atguigu.circle;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(32.1);
        ComparableCircle c2 = new ComparableCircle(33.2);
        int i = c1.compareTo(c2);
        System.out.println(i);
        System.out.println(2);
        int jojo = c1.compareTo(new String("JOJO"));
        System.out.println(jojo);
    }
}

package com.shucai.circle;

public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle(Double radius) {
        super(radius);
    }
    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            if (this.getRadius() > c.getRadius()) {
                return 1;
            }else if (this.getRadius() < c.getRadius()) {
                return -1;
            }else {
                return 0;
            }
        }else {
            throw new RuntimeException("传入的数据不匹配");
//            return 0;
        }
    }
}

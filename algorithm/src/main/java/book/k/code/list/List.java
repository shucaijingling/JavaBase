package book.k.code.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class List {
    public static void main(String[] args) {

        //无初始化值
        java.util.List<Integer> list1 = new ArrayList<>();
        System.out.println(list1);

        //有初始化值
        Integer[] integers = {1, 3, 2, 5, 4};
        java.util.List<Integer> list = new ArrayList<>(Arrays.asList(integers));
        System.out.println(list);

        //访问元素
        int num = list.get(1);
        System.out.println(num);

        //更新元素
        list.set(1,0);
        System.out.println(list);

        //清空列表
        list.clear();

        //尾部添加元素
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        System.out.println("尾部添加： -> ");
        System.out.println(list);

        //中间插入元素
        System.out.println("中间添加： -> ");
        list.add(3,6);
        System.out.println(list);

        //删除元素
        list.remove(3);
        System.out.println("删除元素： -> ");
        System.out.println(list);

        java.util.List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{6, 8, 7, 10, 9}));
        list.addAll(list2);
        Collections.sort(list);
        System.out.println(list);
    }
}

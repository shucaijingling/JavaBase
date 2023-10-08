package com.shucai.interview03;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class TodoHashMap {
    public static void main(String[] args) {

        //初始化一组字符串
        List<String> list = new ArrayList<>();

        list.add("jlkk");
        list.add("lopi");
        list.add("xuyi");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        //定义要存放的数组
        String[] tab = new String[8];

        //循环存放
        for (String key : list) {
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key值=%s Idx=%d", key, idx));

            if (null == tab[idx]) {
                tab[idx] = key;
                continue;
            }

            tab[idx] = tab[idx] + "->" + key;
        }
        System.out.println(JSON.toJSON(tab));
    }
}

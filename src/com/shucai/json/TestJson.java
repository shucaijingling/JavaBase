package com.shucai.json;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class TestJson {

    public static void main(String[] args) {

        String s = "[\"random\",\"fix\",\"discount\"]";

        List<String> strings = JSONArray.parseArray(s, String.class);
        System.out.println(strings);
    }
}

package com.test;

import main.java.com.test.pojo.OOMVO;

import java.util.ArrayList;

public class TestForOOMWithTryCatch {



    public static void main(String[] args) {
        ArrayList<OOMVO> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new OOMVO());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

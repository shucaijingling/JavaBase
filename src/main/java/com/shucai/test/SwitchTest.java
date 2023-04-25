package com.shucai.test;

public class SwitchTest {

    public static void main(String[] args) {
        int a = 1,b = 1;
        switch (a++) {
            case 0: ++a;
            case 1: ++a;
            case 2: ++a;
            case 3: ++a;
        }
        switch (b) {
            case 0: ++b;
            case 1: ++b;
            case 2: ++b;
            case 3: ++b;
        }

        System.out.println(a);
        System.out.println(b);
    }

}

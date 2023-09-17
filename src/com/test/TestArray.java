package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestArray {

    public static void main(String[] args) {

        VO vo = new VO();
        vo.setName("name - 1");
        List<VO> voList = new ArrayList<>();
        voList.add(vo);

        VO[] vos = voList.toArray(new VO[0]);
        for (VO vo1 : vos) {
            System.out.println("::");
            System.out.println(vo1);
        }
        System.out.println(vos);
    }

     static class VO {
        String name ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

         @Override
         public String toString() {
             return "VO{" +
                     "name='" + name + '\'' +
                     '}';
         }
     }
}

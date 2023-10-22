package com.shucai;


import com.shucai.interview04.Disturb;
import com.shucai.interview04.ExcelUtil;
import com.shucai.interview04.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiTest {

    private Set<String> words;

    @Before
    public void init() {
       words = FileUtil.readWords("/Users/x/Downloads/103976个英语单词库.txt");
    }


    @Test
    public void test() throws IOException {
        Map<Integer, Integer> map = new HashMap<>(16);
        Map<Integer, Integer> map2 = new HashMap<>(16);
        for (String word : words) {

            int idx = Disturb.disturbHashIdx(word, 128);

            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            }else {
                map.put(idx, 1);
            }
        }

        for (String word : words) {

            int idx = Disturb.hashIdx(word, 128);
            if (map2.containsKey(idx)) {
                Integer integer = map2.get(idx);
                map2.put(idx, ++integer);
            }else {
                map2.put(idx, 1);
            }
        }
        System.out.println(map.values());
        System.out.println(map2.values());
        List<Integer> list = new ArrayList<>(map.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        ExcelUtil.exportWords("distrub", list, list2);
    }
}

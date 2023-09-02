package main.java.com.test;


import main.java.com.test.pojo.TestStreamVO;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestForStreamSort {

    public static void main(String[] args) {

        HashMap<TestStreamVO, String> map = new HashMap<>();
        TestStreamVO v1 = new TestStreamVO(11111, "4");
        TestStreamVO v2 = new TestStreamVO(2, "3");
        TestStreamVO v3 = new TestStreamVO(3, "2");
        TestStreamVO v4 = new TestStreamVO(4, "1");
        TestStreamVO v5 = new TestStreamVO(3, "1");
        TestStreamVO v6 = new TestStreamVO(6, "1");
        map.put(v1, "1");
        map.put(v2, "2");
        map.put(v3, "3");
        map.put(v4, "4");
        map.put(v5, "1");
        map.put(v6, "2");

        System.out.println(map);

//        Optional<Map.Entry<TestStreamVO, String>> first = map.entrySet().stream().min(Map.Entry.comparingByValue());
//        Map.Entry<TestStreamVO, String> testStreamVOStringEntry = first.get();
//        TestStreamVO key = testStreamVOStringEntry.getKey();
//        System.out.println(key);
        Map<String, TestStreamVO> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (a, b) -> a.getTestKey() > b.getTestKey() ? a : b));
        TestStreamVO value = collect.entrySet().stream().findFirst().get().getValue();
        System.out.println(value);
    }
}

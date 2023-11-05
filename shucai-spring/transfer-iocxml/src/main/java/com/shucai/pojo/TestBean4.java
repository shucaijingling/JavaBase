package com.shucai.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestBean4 {

    private TestBean3 testBean3;

    private String name;

    private float money;

    public TestBean4(TestBean3 testBean3, String name, float money) {
        this.testBean3 = testBean3;
        this.name = name;
        this.money = money;
    }

    private List<String> list;

    private Map<String, String> map;

    private Set<String> set;

    private Properties pros;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    @Override
    public String toString() {
        return "TestBean4{" +
                "testBean3=" + testBean3 +
                ", name='" + name + '\'' +
                ", money=" + money + '\n' +
                ", list=" + list + '\n' +
                ", map=" + map + '\n' +
                ", set=" + set + '\n' +
                ", pros=" + pros + '\n' +
                '}';
    }
}

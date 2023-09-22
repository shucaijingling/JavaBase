package com.test;

import java.util.HashMap;
import java.util.Map;

public class TestGetBeanOfType {

    static Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    static Map<String, Object> beans = new HashMap<>();

    public static void main(String[] args) {


        BeanDefinition beanDefinition1 = new BeanDefinition();
        beanDefinition1.setBeanClass(A1.class);
        addBeanDefinition("A1", beanDefinition1);
        BeanDefinition beanDefinition2 = new BeanDefinition();
        beanDefinition2.setBeanClass(SubA1.class);
        addBeanDefinition("SubA1", beanDefinition2);

        A1 a1 = new A1();
        a1.setV1Name("a1-name");
        addBean("A1", a1);
        SubA1 subA1 = new SubA1();
        subA1.setS1("sub - name");
        subA1.setV1Name("sub - a1 - name");
        addBean("SubA1", subA1);

        Map<String, A1> beanOfType = getBeanOfType(A1.class);

        System.out.println(beanOfType);

    }

    private static void addBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    public static <T> Map<String, T> getBeanOfType(Class<T> type) {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (type.isAssignableFrom(beanDefinition.getBeanClass())) {
                result.put(beanName, getBean(beanName));
            }
        });
        return result;
    }


    private static <T> T getBean(String beanName) {

        return (T) beans.get(beanName);
    }


    private static void addBean(String beanName, Object bean) {
        beans.put(beanName, bean);
    }

    static class BeanDefinition {
        private Class beanClass;

        private String value;

        public Class getBeanClass() {
            return beanClass;
        }

        public void setBeanClass(Class beanClass) {
            this.beanClass = beanClass;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BeanDefinition{" +
                    "beanClass=" + beanClass +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    static class A1 {
        private String v1Name;

        public String getV1Name() {
            return v1Name;
        }

        public void setV1Name(String v1Name) {
            this.v1Name = v1Name;
        }

        @Override
        public String toString() {
            return "A1{" +
                    "v1Name='" + v1Name + '\'' +
                    '}';
        }
    }

    static class SubA1 extends A1 {
        private String s1;

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        @Override
        public String toString() {
            return "SubA1{" +
                    "s1='" + s1 + '\'' + "'v1=" + getV1Name() + '\'' +
                    '}';
        }
    }
}

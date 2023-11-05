package com.shucai.factory;

import com.shucai.pojo.TestBean;
import com.shucai.pojo.TestBean2;

public class CreateBeanFactory {

    public static TestBean getStaticInstance() {
        return new TestBean();
    }

    public TestBean2 getInstance() {
        return new TestBean2();
    }
}

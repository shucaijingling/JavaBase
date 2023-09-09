package com.shucai.concurrent.jmh;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SameClassDataProvider {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {{"data one"}, {"data two"}};
    }


    @Test(dataProvider = "data-provider")
    public void testMethod(String data) {
        System.out.println("Data is : " +  data);
    }
}

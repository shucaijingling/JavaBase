package com.shucai.test;

import com.shucai.ICalculationArea;
import com.shucai.impl.CalculationAreaExt;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_CalculationAreaExt() {
        ICalculationArea cal = new CalculationAreaExt();
        double circular = cal.circular(10);
        System.out.println(circular);
    }
}

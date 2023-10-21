package com.shucai.test;

import com.alibaba.fastjson.JSON;
import com.shucai.CashCard;
import com.shucai.CreditCard;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_CashCard() {
        CashCard cashCard = new CashCard();
        cashCard.withdrawal("10001", new BigDecimal(100));
        cashCard.recharge("10001", new BigDecimal(100));
        List<String> flow = cashCard.tradeFlow();
        logger.info("查询交易流水，{}", JSON.toJSON(flow));
    }


    @Test
    public void test_CreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.withdrawal("10001", new BigDecimal(100));
        creditCard.recharge("10001", new BigDecimal(100));
        List<String> list = creditCard.tradeFlow();
        logger.info("查询交易流水, {}", JSON.toJSON(list));

    }
}

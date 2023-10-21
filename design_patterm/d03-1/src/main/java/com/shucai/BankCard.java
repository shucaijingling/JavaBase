package com.shucai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankCard {

    private Logger logger = LoggerFactory.getLogger(BankCard.class);

    private String cardNo;
    private String cardDate;

    public BankCard(String cardNo, String cardDate) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
    }

    abstract boolean rule(BigDecimal amount);

    // 正向入账， + 钱
    public String positive(String orderId, BigDecimal amount) {
        // 入款成功， 存款 还款
        logger.info("卡号{} 入款成功，单号:{} 金额:{} ", cardNo, orderId, amount);
        return "0000";
    }

    // 逆向入账， - 钱
    public String negative(String orderId, BigDecimal amount) {
        logger.info("卡号{} 出款成功，单号:{} 金额:{} ", cardNo, orderId, amount);
        return "0000";
    }

    /**
     * 交易流水查询
     */
    public List<String> tradeFlow() {
        logger.info("交易流水查询成功");
        List<String> tradeList = new ArrayList<>();
        tradeList.add("10001, 100.00");
        tradeList.add("10001, 80.00");
        tradeList.add("10001, 76.50");
        tradeList.add("10001, 126.00");
        return tradeList;
    }
}

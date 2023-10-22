package com.shucai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class CashCard extends BankCard {


    private Logger logger = LoggerFactory.getLogger(CashCard.class);

    public CashCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }


    /**
     * 提现
     */
    public String withdrawal(String orderId, BigDecimal amount) {
        // 模拟支付成功
        logger.info("提现成功, 单号:{} 金额:{}", orderId, amount);
        return super.negative(orderId, amount);
    }

    /**
     * 储蓄
     */
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟充值成功
        logger.info("储蓄成功, 单号:{} 金额:{}", orderId, amount);
        return super.positive(orderId, amount);
    }

    @Override
    boolean rule(BigDecimal amount) {
        return true;
    }

    /**
     * 风险校验
     */
    public boolean checkRisk(String cardNo, String orderId, BigDecimal amount) {
        // 模拟风控校验
        logger.info("风控校验，卡号:{} 单号:{} 金额:{}", cardNo, orderId, amount);
        return true;
    }
}

package com.shucai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCard extends CashCard{
    private Logger logger = LoggerFactory.getLogger(CreditCard.class);
    public CreditCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

}

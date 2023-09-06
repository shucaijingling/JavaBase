package com.shucai.service.impl;

import com.shucai.dao.AccountDao;
import com.shucai.dao.impl.JdbcAccountDaoImpl;
import com.shucai.pojo.Account;
import com.shucai.service.TransferService;

public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao = new JdbcAccountDaoImpl();


    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);

        accountDao.updateAccountByCardNo(to);
        accountDao.updateAccountByCardNo(from);
    }
}

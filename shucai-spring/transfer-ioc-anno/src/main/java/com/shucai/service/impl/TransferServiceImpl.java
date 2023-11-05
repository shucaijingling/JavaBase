package com.shucai.service.impl;

import com.shucai.dao.AccountDao;
import com.shucai.pojo.Account;
import com.shucai.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transferService")
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

            Account from = accountDao.queryAccountByCardNo(fromCardNo);
            Account to = accountDao.queryAccountByCardNo(toCardNo);

            from.setMoney(from.getMoney() - money);
            to.setMoney(to.getMoney() + money);

            accountDao.updateAccountByCardNo(to);
//            int i = 1 / 0;
            accountDao.updateAccountByCardNo(from);


    }
}

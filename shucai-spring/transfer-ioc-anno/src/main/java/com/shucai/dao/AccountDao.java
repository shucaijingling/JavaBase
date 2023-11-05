package com.shucai.dao;

import com.shucai.pojo.Account;


public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;

}

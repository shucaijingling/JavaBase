package com.shucai.dao.impl;

import com.shucai.dao.AccountDao;
import com.shucai.pojo.Account;
import com.shucai.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository("accountDao")
public class JdbcAccountDaoImpl implements AccountDao {


    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {

//        Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentConn();
        String sql = "select * from account where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()) {
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }
        resultSet.close();
        preparedStatement.close();
//        con.close();
        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
//        Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentConn();
        String sql = "update account set money=? where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, account.getMoney());
        preparedStatement.setString(2, account.getCardNo());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
//        con.close();
        return i;
    }
}

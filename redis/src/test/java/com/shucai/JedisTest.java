package com.shucai;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTest {

    private Jedis jedis;

    /**
     * 连接
     */
    @Test
    public void test() {

        //连接远程redis服务
        Jedis jedis = new Jedis("124.220.15.121", 6379);
        System.out.println("link start");

        //查看服务是否运行
        System.out.println("服务正在运行 ： " + jedis.ping());

    }

    /**
     * 连接
     */
    @Before
    public void link() {
        jedis = new Jedis("124.220.15.121", 6379);
        System.out.println("link start......");
    }


    /**
     * 输出基本信息
     */
    @Test
    public void baseInfo() {
        //client info
        System.out.println("client info");
        System.out.println(jedis.getClient());

        //redis info
        System.out.println("redis info");
        System.out.println(jedis.info());

        //key count
        System.out.println(jedis.dbSize());

        //db name
        System.out.println("db name");
        System.out.println(jedis.getDB());

        //返回当前redis服务器时间，相当于执行TIME命令
        System.out.println("redis服务器时间");
        System.out.println(jedis.time());
    }


    /**
     * redis事务
     */
    @Test
    public void redisTransactionTest() {
        Transaction transaction = jedis.multi();
        transaction.set("userName", "xxx");
        transaction.set("age", "24");
        transaction.set("city", "shanghai");
        transaction.get("userName");
//        transaction.incrBy("userName", 6);
        transaction.incrBy("age", 5);
        transaction.exec();
        //取消事务
//        transaction.discard();
        System.out.println("end....");
        System.out.println(jedis.get("userName"));
        System.out.println(jedis.get("age"));
        System.out.println(jedis.get("city"));

    }

    /**
     * 事务 demo
     */
    @Test
    public void transactionDemo() {

        int balanceA = 0;
        int balanceB = 0;

        int bookPrice = 40;
        int bagPrice = 70;

        String good1 = "book";
        String good2 = "bag";

        //初始化余额为100；
        jedis.set("balanceA", "100");
        System.out.println("buy book");
        shopping(good1, balanceA, bookPrice, balanceB);
        System.out.println("buy bag");
        shopping(good2, balanceA, bagPrice, balanceB);
    }

    public boolean shopping(String goodName, int balanceA, int price, int balanceB) {
        //使用watch命令见识balanceA键
        jedis.watch("balanceA");
        //获取redis数据库中balanceA键的值
        balanceA = Integer.parseInt(jedis.get("balanceA"));

        //如果付款方余额小于所要购买的价格，则取消balanceA的监控，提示余额不足，购买失败
        if (balanceA < price) {
            jedis.unwatch();
            throw new RuntimeException("余额不足");

        } else {
            Transaction tr = jedis.multi();
            tr.decrBy("balanceA", price);//减金额
            tr.incrBy("balanceB", price);//加金额

            //执行事务
            tr.exec();
            balanceA = Integer.parseInt(jedis.get("balanceA"));
            balanceB = Integer.parseInt(jedis.get("balanceB"));
            System.out.println(goodName + "购买成功");
            System.out.println("付款方余额：" + balanceA);
            System.out.println("收款方余额：" + balanceB);
        }
        return true;
    }
}

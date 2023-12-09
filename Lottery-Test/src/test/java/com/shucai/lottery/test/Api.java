package com.shucai.lottery.test;

import com.alibaba.fastjson.JSON;
import com.shucai.lottery.rpc.ActiveBooth;
import com.shucai.lottery.rpc.req.ActivityReq;
import com.shucai.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Api {

    private Logger logger = LoggerFactory.getLogger(Api.class);

    @Reference(interfaceClass = ActiveBooth.class, url = "dubbo://192.168.3.22:20880")
    private ActiveBooth activeBooth;

    @Test
    public void test() {
        ActivityReq req = new ActivityReq();
        req.setActivityId(100001L);
        ActivityRes res = activeBooth.queryActivityById(req);
        logger.info("测试结果：{}", JSON.toJSONString(res));

    }
}

package com.callback;

/**
 * 服务端
 */
public class Service {

    public void getClientMsg(CSCallBack csCallBack, String msg) {
        System.out.println("服务端：服务端接收到客户端发送的消息 ： " + msg);

        //服务端处理数据
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务端：数据处理成功， 返回成功状态200");
        String status = "200";
        csCallBack.processor(status);
    }


}

package com.atguigu.callback;

/**
 * 客户端
 */
public class Client implements CSCallBack{
    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void sendMsg(final String msg) {
        System.out.println(this);
        System.out.println(Client.this);
        System.out.println(this == Client.this);
        System.out.println("客户端发送的消息为：" + msg);
        new Thread(() ->
                service.getClientMsg(this, msg)).start();

        System.out.println("客户端：异步发送成功");
    }


    @Override
    public void processor(String status) {
        System.out.println("客户端： 服务端回调状态为： " + status);
    }
}

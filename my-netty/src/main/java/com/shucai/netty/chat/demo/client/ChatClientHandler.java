package com.shucai.netty.chat.demo.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatClientHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("客户端接收消息....");
        String msg = (String) o;
        System.out.println("客户端接收的消息 ： " + msg);
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端发送消息....");
        ChannelFuture future = ctx.writeAndFlush("hi, 我是客户端");
        if (future.isSuccess()){
            System.out.println("数据发送成功。。。");
        }
        else {
            System.out.println("error");
        }
    }
}

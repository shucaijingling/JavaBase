package com.shucai.netty.chat.demo.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatServerHandler extends SimpleChannelInboundHandler {
    
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("接收消息。。。");
        System.out.println("接收完成。。。发送。。。");
        
        channelHandlerContext.writeAndFlush("服务端收到。。。");
    }
}

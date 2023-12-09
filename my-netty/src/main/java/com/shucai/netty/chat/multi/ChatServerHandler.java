package com.shucai.netty.chat.multi;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    
    private static final List<Channel> CHANNEL_LIST = new ArrayList<>();
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        CHANNEL_LIST.add(channel);
        System.out.println("[server]:" + channel.remoteAddress().toString().substring(1) + "在线.");
    }
    
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        Channel serverChannel = channelHandlerContext.channel();
        for (Channel channel : CHANNEL_LIST) {
            if (channel != serverChannel) {
                channel.writeAndFlush("[" + channel.remoteAddress().toString().substring(1)
                       + "]说:" + msg);
            }
        }
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        
        CHANNEL_LIST.remove(channel);
        
        System.out.println("[server]:" + channel.remoteAddress().toString().substring(1) + "下线.");
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        CHANNEL_LIST.remove(channel);
        System.out.println("[server]:" + channel.remoteAddress().toString().substring(1) + "下线.");
    }
}

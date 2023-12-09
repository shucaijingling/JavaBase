package com.shucai.netty.demo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ClientHandler implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ChannelFuture future = channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("收到，这里是客户端", CharsetUtil.UTF_8));
        if (future.isSuccess()) {
            System.out.println("客户端发送数据成功");
        }else {
            System.out.println(" GG ");
        }
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    /**
     * 读取进站消息
     *
     * @param ctx
     * @param o
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object o) throws Exception {
        ByteBuf byteBuf = (ByteBuf) o;
        System.out.println("服务端： " + byteBuf.toString(CharsetUtil.UTF_8));
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }
    
    @Override
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
    
    }
    
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
    
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
    
    }
}

package com.shucai.netty.chat.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatMessageDecoder extends MessageToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("消息正在解码。。。");
        ByteBuf byteBuf = (ByteBuf) o;
        list.add(byteBuf.toString(CharsetUtil.UTF_8));
    }
}

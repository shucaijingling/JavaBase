package com.shucai.netty.chat.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatMessageEncoder extends MessageToMessageEncoder {

    
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("消息正在编码。。。");
        String msg = (String) o;
        list.add(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
    }
}

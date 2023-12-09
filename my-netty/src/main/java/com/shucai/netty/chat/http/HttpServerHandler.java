package com.shucai.netty.chat.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest) {
            DefaultHttpRequest request = (DefaultHttpRequest) httpObject;
            System.out.println("请求路径：" + request.uri());
            
            if ("/favicon.ico".equals(request.uri())) {
                return;
            }
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,我是客户端", CharsetUtil.UTF_8);
            
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
            
            channelHandlerContext.writeAndFlush(response);
        }
        
    }
}

package com.shucai.netty.c1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class HelloClient {
    public static void main(String[] args) throws InterruptedException {

        //1. 启动器
        new Bootstrap()
                //2. 添加 EventLoop
                .group(new NioEventLoopGroup())
                //3. 选择客户端 channel 实现
                .channel(NioSocketChannel.class)
                //4. 选择处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override //在建立连接后被调用
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 5. 与服务端建立连接
                .connect(new InetSocketAddress( "localhost", 8080))
                .sync()
                .channel()
                .writeAndFlush("hello, netty");
    }
}

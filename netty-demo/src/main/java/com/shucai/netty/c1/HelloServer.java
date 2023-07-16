package com.shucai.netty.c1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class HelloServer {
    public static void main(String[] args) {
        //1.启动器 负责组装netty组件 启动服务器
        new ServerBootstrap()
                //2. boss work 的selector 组
                .group(new NioEventLoopGroup())
                //3. 选择服务器的 ServerSocketChannel 实现
                .channel(NioServerSocketChannel.class)
                //4. boss 负责处理连接 work(child) 负责处理读写，决定了 work(child) 能处理哪些操作 (handler)
                .childHandler(
                        //5. channel 代表和客户端进行数据读写的通道 initializer 初始化 负责添加别的handler
                        new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                        //6. 添加具体 handler
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override //读事件
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                //7. 绑定监听端口
                .bind(8080);
    }
}

package com.shucai.netty.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class Client {
    
    public static void main(String[] args) throws InterruptedException {
        
        // 客户端启动类
        Bootstrap bootstrap = new Bootstrap();
        
        // 读写线程
        NioEventLoopGroup group = new NioEventLoopGroup();
        
        // 设置线程
        bootstrap.group(group)
                //设置通道
                .channel(NioSocketChannel.class)
                //设置通道初始化
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        // 设置处理器
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });
        
        //绑定端口
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8888);
  
        // 关闭连接和通道
        future.channel().closeFuture().sync();
        // 关闭线程
        group.shutdownGracefully();
        
    }
}

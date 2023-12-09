package com.shucai.netty.chat.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class HttpServer {
    
    private int port;
    
    public HttpServer(int port) {
        this.port = port;
    }
    
    private void run() throws InterruptedException {
        NioEventLoopGroup boss = null;
        NioEventLoopGroup work = null;
        
        try {
            boss = new NioEventLoopGroup(1);
            work = new NioEventLoopGroup();
            
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            
                            socketChannel.pipeline().addLast(new HttpServerCodec());
                            socketChannel.pipeline().addLast(new HttpServerHandler());
                            
                            
                        }
                    });
            
            ChannelFuture bind = serverBootstrap.bind(port);
            bind.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("success");
                        
                    } else {
                        System.out.println("error");
                    }
                    
                }
            });
            
            bind.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        new HttpServer(8080).run();
    }
}

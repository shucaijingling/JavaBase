package com.shucai.netty.chat.multi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatServer {
    
    private int port;
    
    public ChatServer(int port) {
        this.port = port;
    }
    
    
    public void run() throws InterruptedException {
        
        NioEventLoopGroup boss = null;
        NioEventLoopGroup work = null;
        try {
            
            boss = new NioEventLoopGroup(1);
            work = new NioEventLoopGroup();
            
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            
            serverBootstrap.group(boss,work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new StringEncoder());
                            socketChannel.pipeline().addLast(new ChatServerHandler());
                        }
                    });
            
            ChannelFuture bind = serverBootstrap.bind(port);
            
            System.out.println("------------聊天室启动-------------");
            bind.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()){
                        System.out.println("端口绑定成功...");
                    }else {
                        System.out.println("端口绑定失败...");
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
        ChatServer chatServer = new ChatServer(6666);
        chatServer.run();
    }
}

package com.shucai.netty.chat.demo.server;

import com.shucai.netty.chat.demo.ChatMessageDecoder;
import com.shucai.netty.chat.demo.ChatMessageEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatServer {
    NioEventLoopGroup bossGroup;
    NioEventLoopGroup workGroup;
    
    private Integer port;
    
    public ChatServer(Integer port) {
        this.port = port;
    }
    
    public void run() throws InterruptedException {
       
        try {
            bossGroup = new NioEventLoopGroup(1);
             workGroup = new NioEventLoopGroup();
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                        
                            // 添加编码器
                            sc.pipeline().addLast("encode",new ChatMessageEncoder());
                            
                            // 添加解码器
                            sc.pipeline().addLast("decode",new ChatMessageDecoder());
                            
                            // 添加处理器
                            sc.pipeline().addLast(new ChatServerHandler());
                        }
                    });
            ChannelFuture bind = serverBootstrap.bind(port);
            
            // 异步监听
            ChannelFuture future = bind.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("端口绑定成功");
                    } else {
                        System.out.println("端口绑定失败");
                    }
                    
                }
            });
            System.out.println("服务端启动成功");
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
        
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        ChatServer chatServer = new ChatServer(6666);
        chatServer.run();
    }
}

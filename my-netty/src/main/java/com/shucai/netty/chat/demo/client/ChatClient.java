package com.shucai.netty.chat.demo.client;

import com.shucai.netty.chat.demo.ChatMessageDecoder;
import com.shucai.netty.chat.demo.ChatMessageEncoder;
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
public class ChatClient {
    
    NioEventLoopGroup group;
    Bootstrap bootstrap;
    
    private String ip;
    
    private int port;
    
    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    
    public void run() throws InterruptedException {
        try {
            group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 编解码器；
                            socketChannel.pipeline().addLast(new ChatMessageDecoder());
                            socketChannel.pipeline().addLast(new ChatMessageEncoder());
                            
                            // 处理器
                            socketChannel.pipeline().addLast(new ChatClientHandler());
                        }
                    });
            System.out.println("客户端连接");
            ChannelFuture connect = bootstrap.connect(ip, port);
            connect.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        ChatClient chatClient = new ChatClient("127.0.0.1", 6666);
        chatClient.run();
    }
}

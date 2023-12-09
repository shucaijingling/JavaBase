package com.shucai.netty.chat.multi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author 蔬菜精灵
 * 禁止焦虑!
 * @description:
 */
public class ChatClient {
    
    private String ip;
    private int port;
    
    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    
    public void run() throws InterruptedException {
        NioEventLoopGroup group = null;
        try {
            Bootstrap bootstrap = new Bootstrap();
            group = new NioEventLoopGroup();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new StringEncoder());
                            socketChannel.pipeline().addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture connect = bootstrap.connect(ip, port).sync();
            Channel channel = connect.channel();
            System.out.println("------------" + channel.localAddress().toString().substring(1) + "------------");
            
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }
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

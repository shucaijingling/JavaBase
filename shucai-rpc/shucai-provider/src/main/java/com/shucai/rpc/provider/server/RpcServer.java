package com.shucai.rpc.provider.server;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

/**
 * @author 蔬菜精灵
 */
@Service
public class RpcServer implements DisposableBean {
    
    private NioEventLoopGroup boss;
    private NioEventLoopGroup work;
    
    public void startServer(String ip, int port) {
        boss = new NioEventLoopGroup(1);
        work = new NioEventLoopGroup();
    }
    
    @Override
    public void destroy() throws Exception {
        if (boss != null) {
            boss.shutdownGracefully();
        }
        
        if (work != null) {
            work.shutdownGracefully();
        }
    }
}

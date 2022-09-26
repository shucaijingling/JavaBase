package com.atguigu.proxy;

import sun.nio.ch.Net;

/**
 * 代理模式
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork {
    void browse();
}
/**
 * 被代理类
 */
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("Server browse NetWork");
    }
}

/**
 * 代理类
 */
class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("check before browse");
    }
    @Override
    public void browse() {
        check();
        work.browse();
    }

}





package com.shucai.netty.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        //设置boss线程
        Thread.currentThread().setName("boss");

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey sscKey = ssc.register(selector, 0, null);
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        ssc.bind(new InetSocketAddress(8081));
        Worker worker = new Worker("worker-01");
        //boss监听accept work监听读写
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                SocketChannel channel = (SocketChannel) key.channel();
                channel.configureBlocking(false);
                //注册work的selector
                worker.register();
            }
        }
    }

    static class Worker implements Runnable{
        private Selector selector;
        private Thread thread;

        private String name;

        private volatile boolean start = false;

        public Worker(String name) {
            this.name = name;
        }

        //只创建一次
        public void register() throws IOException {
            if (!start) {
                selector = Selector.open();
                thread = new Thread(this, name);
                thread.start();
                start = true;
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        SocketChannel channel = (SocketChannel) key.channel();
                        channel.configureBlocking(false);

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

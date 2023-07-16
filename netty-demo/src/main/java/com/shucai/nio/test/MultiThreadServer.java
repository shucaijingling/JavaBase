package com.shucai.nio.test;

import com.shucai.nio.c1.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"all"})
@Slf4j
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
        Worker[] workers = new Worker[2];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("work-" + i);
        }
        AtomicInteger count = new AtomicInteger();
        //boss监听accept work监听读写
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                SocketChannel channel = ssc.accept();
                channel.configureBlocking(false);
                log.debug("connected ... ", channel.getRemoteAddress());
                //注册work的selector
                log.debug("before register...", channel.getRemoteAddress());
                //多个work线程轮询执行读事件
                workers[count.getAndIncrement() % workers.length].register(channel);
                log.debug("after register...", channel.getRemoteAddress());
            }
        }
    }

    static class Worker implements Runnable{
        private Selector selector;
        private Thread thread;

        private String name;

        private volatile boolean start = false;

        private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public Worker(String name) {
            this.name = name;
        }

        //只创建一次
        public void register(SocketChannel sc) throws IOException {
            if (!start) {
                selector = Selector.open();
                thread = new Thread(this, name);
                thread.start();
                start = true;
            }
            //boss线程操作，为让两个线程先后执行，使用队列
//            queue.add(() ->{
//                try {
//                    sc.register(selector, SelectionKey.OP_READ, null);
//                } catch (ClosedChannelException e) {
//                    throw new RuntimeException(e);
//                }
//            });
            selector.wakeup();
            //最简单的方法，直接在wakeup之后直接注册读事件
            sc.register(selector, SelectionKey.OP_READ, null);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    selector.select();
                    //监听到时间之后，将读时间注册到selector
//                    Runnable task = queue.poll();
//                    if (task != null) {
//                        task.run();
//                    }
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                            log.debug("read ... " , channel.getRemoteAddress());
                            channel.read(buffer);
                            buffer.flip();
                            ByteBufferUtil.debugAll(buffer);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

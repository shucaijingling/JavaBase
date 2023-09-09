package com.shucai.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

public class ExchangerExample2 {

    public static void main(String[] args) throws InterruptedException {
        //定义数据类型为String的Exchaner
        final Exchanger<String> exchanger = new Exchanger<>();

        //定义StringGenerator线程，并将该线程命名为Generator
        StringGenerator generator = new StringGenerator(exchanger, "Generator");
        //定义StringConsumer线程，并将该线程命名为Consumer
        StringConsumer consumer = new StringConsumer(exchanger, "Consumer");

        //分别开启线程
        consumer.start();
        generator.start();

        //休眠1分钟后，将Generator和Consumer线程关闭
        TimeUnit.MINUTES.sleep(1);
        consumer.close();
        generator.closed();


    }

    //定义Closable接口
    private interface Closable{
        //关闭方法
        void close();

        //判断当前线程是否被关闭
        boolean closed();
    }

    private abstract static class ClosableThread extends Thread implements Closable {
        protected final Exchanger<String> exchanger;

        private volatile boolean closed = false;

        private ClosableThread(Exchanger<String> exchanger, final String name) {
            super(name);

            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            //当前线程未关闭时 不断执行doExchange()方法
            while (!closed) {
                this.doExchange();
            }
        }

        //抽象方法
        protected abstract void doExchange();

        //关闭当前线程
        @Override
        public void close() {
            System.out.println(currentThread() + "will be closed");
            this.closed = true;
            this.interrupt();
        }

        //当前线程是否被关闭
        @Override
        public boolean closed() {
            return this.closed || this.isInterrupted();
        }
    }

    private static class StringGenerator extends ClosableThread {

        private char initialChar = 'A';
        private StringGenerator(Exchanger<String> exchanger, String name) {
            super(exchanger, name);
        }

        @Override
        protected void doExchange() {
            //模拟复杂的数据生成过程
            String str = "";
            for (int i = 0; i < 3; i++) {
                randomSleep();
                str += (initialChar++);
            }
            try {
                //如果当前线程未关闭，则执行Exchanger的exchange方法
                if (!this.closed()) {
                    exchanger.exchange(str);
                }
            }catch (InterruptedException e) {
                //如果closed()方法之后执行了close方法，那么执行中断操作时此处会捕获到中断信号
                System.out.println(currentThread() + "receive the close signal.");
            }
        }
    }

    private static class StringConsumer extends ClosableThread {

        private StringConsumer(Exchanger<String> exchanger, String name) {
            super(exchanger, name);
        }

        @Override
        protected void doExchange() {

            if (!this.closed()) {
                try {
                    String data = exchanger.exchange(null);
                    System.out.println("received the data: " + data);
                } catch (InterruptedException e) {
                    System.out.println(currentThread() + " received the close signal.");
                }
            }
        }
    }

    //随机休眠
    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(current().nextInt(5));
        } catch (InterruptedException e) {
            //ignore
        }
    }
}

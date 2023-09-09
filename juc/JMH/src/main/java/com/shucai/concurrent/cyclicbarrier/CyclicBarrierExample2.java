package com.shucai.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

public class CyclicBarrierExample2 {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(11);

        for (int i = 0; i < 10; i++) {

            new Thread(new Tourist(i, barrier)).start();
        }
        //主线程也进入阻塞，等待所有游客都上车
        barrier.await();
        System.out.println("Tour Guider:all of Tourist get off the bus.");
    }

    /**
     * 旅游类
     */
    private static class Tourist implements Runnable {

        private final int touristID;

        private final CyclicBarrier barrier;

        private Tourist(int touristID, CyclicBarrier barrier) {
            this.touristID = touristID;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.printf("Tourist:%d by bus\n", touristID);
            //模拟乘客上车的时间开销
            this.spendSeveralSeconds();
            //上车后等待其他同伴上车
            this.waitAndPrint("Tourist:%d Get on the bus, and wait other people reached.\n");
            //模拟乘客下车的时间开销
            this.spendSeveralSeconds();
            //下车后稍作等待，等待其他同伴全部下车
            this.waitAndPrint("Tourist:%d Get off the bus, and wait other people get off. \n");
        }

        private void waitAndPrint(String message) {
            System.out.printf(message, touristID);
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                //ignore
            }
        }

        //random sleep
        private void spendSeveralSeconds() {
            try {
                TimeUnit.SECONDS.sleep(current().nextInt(10));
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}

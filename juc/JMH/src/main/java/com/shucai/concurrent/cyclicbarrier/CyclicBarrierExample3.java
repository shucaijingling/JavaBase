package com.shucai.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample3 {


    public static void main(String[] args) throws InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        Thread thread = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);

        barrier.reset();
        TimeUnit.SECONDS.sleep(2);

        System.out.println(barrier.isBroken());
    }
}

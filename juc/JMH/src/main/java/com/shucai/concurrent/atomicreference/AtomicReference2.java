package com.shucai.concurrent.atomicreference;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 加锁，实现高并发下，对账户修改的原子性
 *  缺点：只有一个线程在真正运行，其他的线程都在阻塞
 */
public class AtomicReference2 {

    static volatile DebitCard debitCard = new DebitCard("Alex", 0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread("T-" + i) {
                @Override
                public void run() {
                    while (true) {
                        synchronized (AtomicReference2.class) {
                            final DebitCard dc = debitCard;

                            DebitCard newDC = new DebitCard(dc.getAccount(), dc.getAmount() + 10);

                            System.out.println(newDC);

                            debitCard = newDC;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(current().nextInt(20));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}

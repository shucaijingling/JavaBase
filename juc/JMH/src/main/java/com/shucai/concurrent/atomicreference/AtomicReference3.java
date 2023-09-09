package com.shucai.concurrent.atomicreference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 使用AtomicReference进行优化【非阻塞的方式】
 */
public class AtomicReference3 {

    private static AtomicReference<DebitCard> ref = new AtomicReference<>(new DebitCard("Alex", 0));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread("T-" + i) {
                @Override
                public void run() {
                    while (true) {
                        synchronized (AtomicReference3.class) {
                            final DebitCard dc = ref.get();

                            DebitCard newDC = new DebitCard(dc.getAccount(),  dc.getAmount() + 10);

                            if (ref.compareAndSet(dc, newDC)) {
                                System.out.println(newDC);
                            }

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

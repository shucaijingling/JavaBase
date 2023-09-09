package com.shucai.concurrent.atomicreference;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

public class AtomicReference1 {

    static volatile DebitCard debitCard = new DebitCard("Alex", 0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread("T-" + i) {
                @Override
                public void run() {
                    while (true) {
                        final DebitCard dc = debitCard;

                        DebitCard newDC = new DebitCard(dc.getAccount(), dc.getAmount() + 10);

                        System.out.println(newDC);

                        debitCard = newDC;

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

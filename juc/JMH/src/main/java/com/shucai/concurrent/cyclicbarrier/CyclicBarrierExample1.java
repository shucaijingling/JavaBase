package com.shucai.concurrent.cyclicbarrier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class CyclicBarrierExample1 {

    static class ProductPrize {
        private final int prodId;

        private double price;

        private ProductPrize(int prodId) {
            this(prodId, -1);
        }

        private ProductPrize(int prodId, double price) {
            this.prodId = prodId;
            this.price = price;
        }

        public int getProdId() {
            return prodId;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductPrize{" +
                    "prodId=" + prodId +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {

        //生成一组商品id
        final int[] products = getProductByCategoryId();

        List<ProductPrize> list = Arrays.stream(products).mapToObj(ProductPrize::new).collect(Collectors.toList());

        //定义CyclicBarrier，指定子任务数量
        final CyclicBarrier barrier = new CyclicBarrier(list.size());

        //用于存放线程任务的list
        final List<Thread> threadList = new ArrayList<>();

        list.forEach(pp -> {
            Thread thread = new Thread(() -> {
                System.out.println(pp.getProdId() + "->start calculate price");

                //模拟耗时调用
                try {
                    long start = System.currentTimeMillis();
                    TimeUnit.SECONDS.sleep(current().nextInt(10));
                    if (pp.getProdId() % 2 == 0) {
                        pp.setPrice(pp.getProdId() * 0.9D);
                    }else {
                        pp.setPrice(pp.getProdId() * 0.71D);
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(pp.getProdId() + "->price calculate completed...  cost : " + (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //等待其他子线程到达barrier point
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
//                        throw new RuntimeException(e);
                    }
                }
            });
            threadList.add(thread);
            thread.start();
        });
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("all of prices calculate finished.");
        list.forEach(System.out::println);
    }

    private static int[] getProductByCategoryId() {
        return IntStream.rangeClosed(1,10).toArray();
    }
}

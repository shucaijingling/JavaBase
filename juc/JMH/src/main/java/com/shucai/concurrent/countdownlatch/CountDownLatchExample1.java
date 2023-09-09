package com.shucai.concurrent.countdownlatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;


public class CountDownLatchExample1 {

    private static class ProductPrize {
        private final int prodID;
        private double price;

        private ProductPrize(int prodID) {
            this(prodID, -1);
        }

        private ProductPrize(int prodID, double price) {
            this.prodID = prodID;
            this.price = price;
        }

        public int getProdID() {
            return prodID;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductPrize{" +
                    "prodID=" + prodID +
                    ", price=" + price +
                    '}';
        }
    }


    public static void main(String[] args) throws InterruptedException {

        //获取商品编号的列表
        final int[] products = getProductsByCategoryId();
        //转换成ProductPrize对象
        List<ProductPrize> list = Arrays.stream(products).mapToObj(ProductPrize::new).collect(Collectors.toList());

        //定义countDownLatch，数量为子任务的个数
        final CountDownLatch latch = new CountDownLatch(products.length);

        list.forEach(pp ->
                new Thread(() -> {
                    System.out.println(pp.getProdID() + "-> start calculate prize.");

                    try {
                        long start = System.currentTimeMillis();
                        //模拟其他系统调用耗时
                        TimeUnit.SECONDS.sleep(current().nextInt(10));

                        //计算价格
                        if (pp.getProdID() % 2 == 0) {
                            pp.setPrice(pp.getProdID() * 0.9D);
                        } else {
                            pp.setPrice(pp.getProdID() * 0.71D);
                        }

                        long end = System.currentTimeMillis();
                        System.out.println(pp.getProdID() + "-> prize calculate completed..." + "cost: " + (end - start));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //子任务执行完成，计数器减一
                        latch.countDown();
                    }
                }).start()
        );
        //主线程阻塞等待所有子任务结束，但凡有一个子任务没有完成都会一直等待
        latch.await();
        System.out.println("all of prices calculate finished.");
        list.forEach(System.out::println);
    }

    //根据品类id获取商品列表
    private static int[] getProductsByCategoryId() {
        return IntStream.rangeClosed(1, 10).toArray();
    }
}

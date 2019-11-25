package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author huazhen.he
 * @apiNote
 * @date 2019/1/8
 */
public class DemoPallaral {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        //IntStream.rangeClosed(0, 30).parallel().forEach(i -> func());
        final ExecutorService executorService = Executors.newFixedThreadPool(20);
        final CountDownLatch countDownLatch = new CountDownLatch(30);
        IntStream.rangeClosed(1,30).forEach(i->executorService.execute(()->{
            func();
            countDownLatch.countDown();
        }));
        countDownLatch.await();
        final long end = System.currentTimeMillis();
        System.out.println("执行时间:" + (end - start)+"ms");
        System.out.println("count=" + count);
        executorService.shutdown();
    }

    public static void func() {
        count++;
        try {
            Thread.sleep(300L);
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

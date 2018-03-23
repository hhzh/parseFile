package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSubmit {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Future<String> submit = executorService.submit(new FutureThread("name" + i));
            System.out.println("提交"+i);
            //try {
            //    String obj = submit.get();
            //    System.out.println("++ "+obj);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //} catch (ExecutionException e) {
            //    e.printStackTrace();
            //}
            futures.add(submit);
        }

        System.out.println("提交完毕：");
        for (Future future : futures) {
            try {
                Object obj = future.get();
                System.out.println(obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}

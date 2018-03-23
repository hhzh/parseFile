package com.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoSingle {

    public static void main(String[] args) {
        new DemoSingle().hello();
        System.out.println("xxxx");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
    }

    public void hello() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            for (int i = 0; i < 10; i++) {
                executorService.submit(new DemoThread());
            }
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}

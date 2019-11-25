package com.thread;

public class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕。");
    }
}

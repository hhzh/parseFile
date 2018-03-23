package com.thread;

import java.util.concurrent.Callable;

public class FutureThread implements Callable<String> {

    private String name;

    public FutureThread() {
    }

    public FutureThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"--"+name+"---正在执行！");
        Thread.sleep(1000);
        return name+"**";
    }
}

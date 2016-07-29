package com.madhu.threads;

public class Thread2 extends Thread {
    Message msg;

    public Thread2(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (msg) {
            System.out.println("in Sycn block 2");
            msg.notify();
        }
        long start = System.currentTimeMillis();
        System.out.println("Runnable 1");
        long end = System.currentTimeMillis();
        System.out.println("Total time for Runnable " + (end - start));
    }

}

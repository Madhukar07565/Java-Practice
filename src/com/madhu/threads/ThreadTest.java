package com.madhu.threads;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Madhukar Reddy
 *
 */
public class ThreadTest implements Runnable {

    static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        /*
         * Thread t = new Thread(new ThreadTest()); t.start();
         * 
         * Thread t1 = new Thread(new ThreadTest()); t1.start();
         */
        System.out.println("Current Time = " + new Date());
        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.schedule(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                    }
                }
            }, 10, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();

    }

}

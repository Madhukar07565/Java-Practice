package com.madhu.threads;

/**
 * Created By Madhukar Reddy On Jun 24, 2015
 *
 */
public class EvenOddNumberThread {

    public static void main(String[] args) throws Exception {

        Object o = new Object();

        Thread eThread = new Thread(new EvenThread(o),"EvenThread");
        Thread oThread = new Thread(new OddThread(o),"OddThread");
        oThread.start();
        eThread.start();
    }

}

class EvenThread implements Runnable {

    private Object o;

    public EvenThread(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    o.notify();
                    System.out.println("Even: " + i);
                    System.out.println(Thread.currentThread().getName());
                    try {
                        o.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
            o.notify();
        }
    }

}

class OddThread implements Runnable {

    private Object o;

    public OddThread(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            for (int i = 1; i < 10; i++) {
                if (i % 2 != 0) {
                    o.notify();
                    System.out.println("Odd: " + i);
                    System.out.println(Thread.currentThread().getName());
                    try {
                        o.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
            o.notify();
        }
    }

}

package com.madhu.threads;

public class Thread1 extends Thread {

    Message msg;

    public Thread1(Message msg) {
        this.msg = msg;
    }

    public void run() {
        synchronized (msg) {
            System.out.println("in sync block");
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread 1");
    }

    public static void main(String[] args) throws Exception {
       // Message m1 = new Message("Hello Msg");
       // Thread1 t1 = new Thread1(m1);
       // Thread2 t2 = new Thread2(m1);
       // t1.start();
       // System.out.println(t1.getState());
        //t2.start();
        Thread1.sleep(2000);
       // System.out.println(t1.isAlive());
       // System.out.println("Thread Name is >>>"+t1.getState());
        //new Thread(t1, "Thread1").start();
        //new Thread(t2, "Thread2").start();
    }
}

package com.madhu.threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Madhukar Reddy On Jul 6, 2015
 *
 */
public class ProducerConsumerUsingWaitAndNotify {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

    }
}

class Producer implements Runnable {

    Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            synchronized (queue) {
                if (queue.size() == 10) {
                    System.out.println("Queue is full wait to consume");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    queue.add("Hello" + i);
                    System.out.println("Producing .... Hello...." + i);
                    //queue.notify();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            synchronized (queue) {
                if (queue.size() == 0) {
                    try {
                        System.out.println("Queue is empty wait to fill");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Consuming .... " + queue.poll());
                    //queue.notify();
                }
            }
        }
    }
}

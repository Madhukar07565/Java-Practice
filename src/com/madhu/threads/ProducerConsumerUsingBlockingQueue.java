package com.madhu.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created By Madhukar Reddy On Jul 6, 2015
 *
 */
public class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        Thread producerThread = new Thread(new Producer1(queue));
        Thread consumerThread = new Thread(new Consumer1(queue));

        producerThread.start();
        consumerThread.start();
    }

}

class Producer1 implements Runnable {

    BlockingQueue<String> queue;

    public Producer1(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Producing Heloo >> " + i);
                queue.put("Hello >> " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer1 implements Runnable {

    BlockingQueue<String> queue;

    public Consumer1(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("Consuming " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

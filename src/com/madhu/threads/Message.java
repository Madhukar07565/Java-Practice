package com.madhu.threads;

public abstract class Message {
    String msg;

    public Message(String str) {
        this.msg = str;
        System.out.println(str);
    }

    public synchronized String get1() {
        return get();
    }

    public abstract String get();

    public static void main(String[] args) {
        System.out.println("Hey...");
    }
}

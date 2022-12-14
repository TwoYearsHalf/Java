package com.google.thread.threadCommunication;


public class NumberTest extends Thread {

    public int number = 1000;

    public synchronized void addNumber() {
        number = number + 1;

        this.notify();
        System.out.println("number+1后 ，number = " + number);
    }

    public synchronized void reduceNumber() {
        while(true) {
            if (number == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            number = number - 1;

            System.out.println("number-1 后 ，number = " + number);
        }
    }
}

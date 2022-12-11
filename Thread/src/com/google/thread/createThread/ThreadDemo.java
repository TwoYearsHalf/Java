package com.google.thread.createThread;

public class ThreadDemo extends Thread{
    public void run() {
        while(true) {
            try {
                sleep(1000L);
            } catch (Exception var2) {
                var2.printStackTrace();
            }

            System.out.println("...This is a new Thread from ThreadDemo Class...");
        }
    }
}

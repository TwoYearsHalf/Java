package com.google.thread.createThread;

import static java.lang.Thread.sleep;

public class SubRunnable implements Runnable {
    public void run() {
        while (true) {
            try {
                sleep(1000L);
                System.out.println("...This is a new Thread from SubRunnable Class...");
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }
    }
}


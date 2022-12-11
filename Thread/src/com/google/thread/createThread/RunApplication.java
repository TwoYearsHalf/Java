package com.google.thread.createThread;

public class RunApplication {
    public static void main(String[] args) {
        (new ThreadDemo()).start();
        (new Thread(new SubRunnable())).start();
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000L);
                        System.out.println("...This is a new Thread from 'Thread内部类' ...");
                    } catch (Exception var2) {
                        var2.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}


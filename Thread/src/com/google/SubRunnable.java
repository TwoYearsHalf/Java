package com.google;

public class SubRunnable extends Thread implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                sleep(1000);
                System.out.println("...This is a new Thread from SubRunnable Class...");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }

    }
}

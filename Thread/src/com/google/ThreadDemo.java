package com.google;

public class ThreadDemo extends Thread {

    // 重写run()方法
    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            }catch (Exception exception){
                exception.printStackTrace();
            }
            System.out.println("...This is a new Thread from ThreadDemo Class...");
        }
    }
}

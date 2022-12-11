package com.google.thread.concurrency;

public class RunApplication {
    public static void main(String[] args) {


        Test test = new Test();
        test.number = 10000;
        Thread[] addThreads = new Thread[10000];
        Thread[] reduceThreads = new Thread[10000];
        // addNumber
        for (int i = 0; i < 10000; i++) {
            Thread thread_1 = new Thread() {
                public void run(){
                    test.addNumber();
                }
            };
            thread_1.start();
            addThreads[i] = thread_1;

        }

        // reduceNumber
        for (int i = 0; i < 10000; i++) {
            Thread thread_2 = new Thread(){
                public void run(){
                    test.reduceNumber();
                }
            };
            thread_2.start();
            reduceThreads[i] = thread_2;
        }

        // 等待所有线程结束
        for (Thread thread :
                addThreads) {
            try {
                thread.join();
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
        for (Thread thread :
                reduceThreads) {
            try {
                thread.join();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        System.out.println(test.number);
    }
}

package com.google.thread.concurrency;

public class TestApplication {
    public static void main(String[] args) {


        Test test = new Test();
        test.number = 10000;
        Thread[] addThreads = new Thread[1000];
        Thread[] reduceThreads = new Thread[1000];

        // addNumber
        for (int i = 0; i < 1000; i++) {
            Thread thread_1 = new Thread() {
                public void run() {
                        test.addNumber();
                    }
            };
            thread_1.start();
            addThreads[i] = thread_1;
        }

        // reduceNumber
        for (int i = 0; i < 1000; i++) {
            Thread thread_2 = new Thread() {
                public void run() {
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
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        for (Thread thread :
                reduceThreads) {
            try {
                thread.join();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // 最终结果并不是10000
        System.out.println(test.number);
    }
}

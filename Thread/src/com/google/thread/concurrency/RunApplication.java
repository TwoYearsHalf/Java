package com.google.thread.concurrency;

public class RunApplication {
    public static void main(String[] args) {
/*
synchronized表示当前线程，独占 对象 someObject
当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
someObject 又叫同步对象，所有的对象，都可以作为同步对象
为了达到同步的效果，必须使用同一个同步对象
 */
        Object object = new Object();
        Test test = new Test();
        test.number = 10000;
        Thread[] addThreads = new Thread[1000];
        Thread[] reduceThreads = new Thread[1000];
        // addNumber
        for (int i = 0; i < 1000; i++) {
            Thread thread_1 = new Thread() {
                public void run() {

                    // 利用 synchronized 关键字
                    synchronized (object) {
                        test.addNumber();
                    }
                }
            };
            thread_1.start();
            addThreads[i] = thread_1;
        }

        // reduceNumber
        for (int i = 0; i < 1000; i++) {
            Thread thread_2 = new Thread() {
                public void run() {
                    synchronized (object) {
                        test.reduceNumber();
                    }
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

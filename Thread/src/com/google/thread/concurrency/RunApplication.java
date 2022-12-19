package com.google.thread.concurrency;

public class RunApplication {
    public static void main(String[] args) {
/*
synchronized表示当前线程，独占 对象 object
当前线程独占了对象object，如果有其他线程试图占有对象object，就会等待，直到当前线程释放对object的占用。
object 又叫同步对象，所有的对象，都可以作为同步对象
为了达到同步的效果，必须使用同一个同步对象

注意：多个线程在执行synchronized同步代码块时，代码块括号里面可以传入任意对象，但一定要保证多个线程访问的是同一个锁对象。synchronized锁住的是对象，并不是代码，下面代码中锁住的是我们自己创建的obj对象，若synchronized加在方法上时，锁住的是当前class的字节码文件对象
 */
//        Object object = new Object();
//        Test test = new Test();
//        test.number = 10000;
//        Thread[] addThreads = new Thread[1000];
//        Thread[] reduceThreads = new Thread[1000];
//        // addNumber
//        for (int i = 0; i < 1000; i++) {
//            Thread thread_1 = new Thread() {
//                public void run() {
//
//                    // 利用 synchronized 关键字
//                    synchronized (object) {
//                        test.addNumber();
//                    }
//                }
//            };
//            thread_1.start();
//            addThreads[i] = thread_1;
//        }
//
//        // reduceNumber
//        for (int i = 0; i < 1000; i++) {
//            Thread thread_2 = new Thread() {
//                public void run() {
////                    synchronized (object) {
//                        test.reduceNumber();
//                    }
////                }
//            };
//            thread_2.start();
//            reduceThreads[i] = thread_2;
//        }
//
//        // 等待所有线程结束
//        for (Thread thread :
//                addThreads) {
//            try {
//                thread.join();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//
//        }
//        for (Thread thread :
//                reduceThreads) {
//            try {
//                thread.join();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//        // 最终结果并不是10000
//        System.out.println(test.number);


        // 卖票 ——> SellTickets
        // new一个Runnable子类
        SellTickets sellTickets = new SellTickets();

        // 将Runnable的实现类作为参数传递给Thread构造方法
        Thread thread_1 = new Thread(sellTickets,"万达");
        Thread thread_2  =new Thread(sellTickets,"淘票票");
        Thread thread_3 = new Thread(sellTickets,"飞猪");

        // 三个线程都开启，开始卖票
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

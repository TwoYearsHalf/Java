package com.google.thread.deadLock;

/*
 死锁问题
 在编写多线程代码时一定要注意避免死锁，发生死锁原因就是两个或多个线程在持有一个锁对象之后想要在获取对方手中的对象，此时都在等待对方释放锁导致死锁，下面通过代码来演示一下死锁情况。运行之后程序不会停止
 联系之前同步锁的概念
 */
public class DeadThread {
    // 创建两个Object对象 用于同步锁
    private static Object object_1 = new Object();
    private static Object object_2 = new Object();

    public static void main(String[] args) {


        Thread thread_1 = new Thread() {
            public void run() {

                // 同步代码块获取object_1对象
                synchronized (object_1) {
                    System.out.println(Thread.currentThread().getName() + "...object_1");
                }

                // 然后获取object_2对象
                synchronized (object_2) {
                    System.out.println(Thread.currentThread().getName() + "...object_2");
                }
            }
        };

        Thread thread_2 = new Thread() {
            public void run() {

                // 同步代码块获取object_2对象
                synchronized (object_2) {
                    System.out.println(Thread.currentThread().getName() + "...object_2");
                }

                // 然后获取object_1对象
                synchronized (object_1) {
                    System.out.println(Thread.currentThread().getName() + "...object_1");
                }
            }
        };

        // 相互锁住 导致死锁发生
        thread_1.start();
        thread_2.start();

    }

}

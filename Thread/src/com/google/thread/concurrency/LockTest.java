package com.google.thread.concurrency;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/*
我们可以通过ReentrantLock中的lock()方法获得锁，unlock()方法释放锁。在使用的时候需要保证多个线程争抢的是同一个ReentrantLock对象，否则仍然会出现线程安全问题。
 */
public class LockTest {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取锁
                    lock.lock();
                    for (int i = 0; i < 100; i++) {
                        sleep(100);
                        System.out.println(Thread.currentThread().getName() + "---->" + i);

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }finally {
                    // 防止上面出现异常之后无法释放锁
                    lock.unlock();
                }

            }
        };

        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);
        Thread thread_3 = new Thread(runnable);

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

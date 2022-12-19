package com.google.thread.concurrency;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

// 多线程卖票，，卖一张少一张
public class SellTickets implements Runnable {
    // 定义总票数
    private int tickets = 100;

    // 创建锁对象
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 获得锁
                lock.lock();
                // 票数为0就退出
                if (tickets <= 0) {
                    break;
                }
                // 每次购买后票数-1
                else {
                    sleep(1000);
                    tickets = tickets - 1;
                    System.out.println(Thread.currentThread().getName() + "卖出一张，剩余 " + tickets);

                }
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
                // 防止出现异常之后没有释放锁导致死锁现象
                // 释放锁
                lock.unlock();
            }
        }

    }
}

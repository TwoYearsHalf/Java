package com.google.thread.threadCommunication;

public class Customer extends Thread {
    private Condom condom;

    public Customer(Condom condom) {
        this.condom = condom;
    }

    @Override
    public void run() {
        while (true) {
            // 谁调用这个套 这个锁就属于谁 这里是消费者调用 所以消费者等待
            synchronized (condom) {
                // 避孕套是否有库存？如果没有 应该通知厂商，我们 wait() ！！！
                if (condom.isStatus == false) {
                    try {
                        // 没有避孕套了 消费者死等！！！
                        condom.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 如果卖光了？那就要通知生产者生产避孕套 =====  唤醒 Producer 线程
                condom.isStatus = false;
                condom.notify();
                System.out.println(Thread.currentThread().getName() + "避孕套卖光了！！唤醒你！！！ 速速生产^_^");


            }
        }
    }
}

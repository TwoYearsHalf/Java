package com.google.thread.threadCommunication;

// 避孕套生产厂家
public class Producer extends Thread {

    private Condom condom;

    public Producer(Condom condom) {
        this.condom = condom;
    }

    @Override
    public void run() {
        while (true) {
            // 谁调用这个套 这个锁就属于谁  这里是生产者调用，所以是生产者等待
            synchronized (condom) {
                // 避孕套是否有库存？ 如果还有 等待消费者买完  再生产
                if (condom.isStatus == true) {
                    try {
                        // 等待消费者买完
                        condom.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 如果库存还有？  通知消费者购买
               condom.isStatus = true;

                   System.out.println(Thread.currentThread().getName() + "有库存了！！欲购从速！！！");
                   condom.notify();



            }
        }

    }

}

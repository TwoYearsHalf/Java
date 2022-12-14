package com.google.thread.threadCommunication;

import static java.lang.Thread.sleep;

/*
线程交互(线程通信)  等待唤醒机制

多线程环境下CPU会随机的在线程之间进行切换，如果想让两个线程有规律的去执行，那就需要两个线程之间进行通信，在Object类中的两个方法wait和notify可以实现通信。

wait方法可以使当前线程进入到等待状态，在没有被唤醒的情况下，线程会一直保持等待状态。
notify方法可以随机唤醒单个在等待状态下的线程。

举一个现实生活中的例子
冈本避孕套生产厂家  消费者   两者之间的关系
1.消费者一直买避孕套 ———— 当消费者把避孕套买完了，此时消费者处于等待状态，并通知厂家生产避孕套
2.厂家拿到通知，立刻生产避孕套，并通知消费者购买避孕套，此时厂家处于等待状态
 */
public class RunApplication {
    public static void main(String[] args) {
//        Condom condom = new Condom();
//        new Customer(condom).start();
//        new Producer(condom).start();

        // 如果上面的例子不好理解  可以用对一个数字的加减操作再次演示
          /*
    定义一个数字 number ，给定数值
    两个方法
    addNumber() 每次只+1
    reduceNumber() 每次只-1
    当数字number被减到=1时 唤醒addNumber
    当数字number>1时  唤醒reduceNumber
     */

        int number = 1000;
        NumberTest numberTest = new NumberTest();
       Thread thread_1 = new Thread(()->{
           while(true) {
               try {
                   sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               numberTest.addNumber();
           }
        });

        Thread thread_2 = new Thread(()->{
            while(true) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                numberTest.reduceNumber();
            }
        });

        thread_1.start();
        thread_2.start();

    }
}

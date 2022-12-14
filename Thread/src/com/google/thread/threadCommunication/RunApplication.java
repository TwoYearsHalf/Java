package com.google.thread.threadCommunication;

import static java.lang.Thread.sleep;

/*
线程交互(线程通信)  等待唤醒机制

多线程环境下CPU会随机的在线程之间进行切换，如果想让两个线程有规律的去执行，那就需要两个线程之间进行通信，在Object类中的两个方法wait和notify可以实现通信。

wait方法可以使当前线程进入到等待状态，在没有被唤醒的情况下，线程会一直保持等待状态。
notify方法可以随机唤醒单个在等待状态下的线程。

这里需要强调的是，wait方法和notify方法，并不是Thread线程上的方法，它们是Object上的方法。
因为所有的Object都可以被用来作为同步对象，所以准确的讲，wait和notify是同步对象上的方法。
wait()的意思是： 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。
notify() 的意思是，通知一个等待在这个同步对象上的线程，你可以苏醒过来了，有机会重新占用当前对象了。
notifyAll() 的意思是，通知所有的等待在这个同步对象上的线程，你们可以苏醒过来了，有机会重新占用当前对象了。

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

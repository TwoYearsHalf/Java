package com.google.thread.concurrency;

// 这个类用于测试线程安全问题
public class Test extends Thread{
    //成员变量存储在堆内存里面，多个线程可以访问同一个堆内存
    //即多个线程可以同时修改num的值，这样会导致线程安全问题

    // 加减数字同时进行, 初始数字是10000,每次+1 每次-1, 加减各1000次 理论上来说最终的数字依旧是10000
    // 每一次加减都是一个线程
    int number ;

    // 加
    public void addNumber() {
        try {
            sleep(1);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        number = number + 1;
//        System.out.println("...number = " + number);

    }

    // 减
    public void reduceNumber() {
        try {
            sleep(10);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        number = number - 1;
//        System.out.println("...number = " + number);
    }
}

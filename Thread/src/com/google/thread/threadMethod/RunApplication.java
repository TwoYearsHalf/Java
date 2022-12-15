package com.google.thread.threadMethod;

public class RunApplication {
    public static void main(String[] args) {

//        // sleep() 当前线程暂停
//        Thread thread_1 = new Thread() {
//            public void run() {
//                while (true) {
//                    try {
//                        sleep(1000);
//                        System.out.println(getName() + "...暂停...");
//                    } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread_1.setName("Thread_1");
//        thread_1.start();
//
//
////        // join() 加入线程
//        Thread thread_2 = new Thread() {
//            public void run() {
//                try {
//                    System.out.println("...thread_1 进来了 ....");
//                    // 加入线程 只有thread_1 运行结束，才会继续往下执行
//                    thread_1.join();
//                    // 因为thread_1线程会永远运行下去 仔细看thread_1的代码
//                    System.out.println("...这个输出永远也出不来了...");
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }
//        };
//        thread_2.setName("Thread_2");
//        thread_2.start();
//
//        // 线程优先级
//        // 当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
//        // 为了演示该效果，要把暂停时间去掉，多条线程各自会尽力去占有CPU资源
//        Thread thread_3 = new Thread() {
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + "...正在抢占CPU资源...");
//                }
//            }
//        };
//        thread_3.setName("Thread_3");
//
//
//        Thread thread_4 = new Thread() {
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + "...正在抢占CPU资源...");
//                }
//            }
//        };
//        thread_4.setName("Thread_4");

////
////
////        // 设置线程优先级,也可以填数字 1-10  主线程Main()优先级为5
////
////        // 最大优先级
//        thread_3.setPriority(Thread.MAX_PRIORITY);
////        // 最小优先级
//        thread_4.setPriority(Thread.MIN_PRIORITY);
////
//        thread_3.start();
//        thread_4.start();

////
//        // yield() 线程临时暂停，是的别的线程有更多机会占用CPU资源
//        Thread thread_5 = new Thread() {
//            public void run() {
//                while (true) {
//                    // 静态方法 类名.方法
//                    Thread.yield();
//                    System.out.println(Thread.currentThread().getName() + "...正在抢占CPU资源...");
//                }
//            }
//        };
//        thread_5.setName("Thread_5");
//        thread_5.start();

        // 守护线程 setDaemon()
        // 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程
        Thread thread_6 = new Thread() {
            public void run() {
                while(true) {
                    try {
                        sleep(1000);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    System.out.println(getName() + "...");
                }
            }
        };
        thread_6.setName("Thread_6");

        // 设置守护线程 如果是true  那么不会打印线程名称，直接结束线程
        thread_6.setDaemon(true);
        thread_6.start();


    }
}

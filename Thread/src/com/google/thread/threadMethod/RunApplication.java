package com.google.thread.threadMethod;

public class RunApplication {
    public static void main(String[] args) {

        // sleep() 当前线程暂停
        Thread thread_1 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        System.out.println(getName() + "...暂停...");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };
        thread_1.start();


        // join() 加入线程
        Thread thread_2 = new Thread(){
            public void run(){
                try{
                    System.out.println("...thread_1 进来了 ....");
                    // 加入线程 只有thread_1 运行结束，才会继续往下执行
                    thread_1.join();
                    // 因为thread_1线程会永远运行下去 仔细看thread_1的代码
                    System.out.println("...这个输出永远也出不来了...");
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        };
        thread_2.start();


    }
}

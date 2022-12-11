package com.google;

/*
Java 的线程是通过 java.lang.Thread 类来实现的。VM 启动时会有一个由主方法所定义的线程。
可以通过创建 Thread 的实例来创建新的线程。
每个线程都是通过某个特定 Thread 对象所对应的方法 run() 来完成其操作的，方法 run() 称为线程体。
通过调用 Thread 类的 start() 方法来启动一个线程。

    1.start() 方法来启动线程，真正实现了多线程运行。
    这时无需等待 run 方法体代码执行完毕，可以直接继续执行下面的代码；
    通过调用 Thread 类的 start() 方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。
    然后通过此 Thread 类调用方法 run() 来完成其运行操作的，
    这里方法 run() 称为线程体，它包含了要执行的这个线程的内容， run 方法运行结束， 此线程终止。
    然后 CPU 再调度其它线程。

    2.run() 方法当作普通方法的方式调用。
    程序还是要顺序执行，要等待 run 方法体执行完毕后，才可继续执行下面的代码；
    程序中只有主线程——这一个线程， 其程序执行路径还是只有一条， 这样就没有达到写线程的目的

开启多线程三种方法
    1.继承Thread 子类重写run()方法，调用start() 开启新线程
    2.实现Runnable接口,重写run()方法,new一个实现类对象,并作为参数传递给Thread类的构造方法,调用start() 开启新线程
    3.创建Thread内部类
 */
public class RunApplication {
    public static void main(String[] args) {

        // 第一种方式
        new ThreadDemo().start();

        // 第二种方式
        new Thread(new SubRunnable()).start();

        // 第三种方式
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        System.out.println("...This is a new Thread from 'Thread内部类' ...");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };

        // 开启新线程
        thread.start();

    }
}

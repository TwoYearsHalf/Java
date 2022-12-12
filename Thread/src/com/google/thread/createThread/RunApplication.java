package com.google.thread.createThread;

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
    创建多线程的三种方法：

启动线程办法： 实例化一个Thread子类对象，并且调用其start（）方法

第一种：继承Thread类
在子类中称重写run（）方法，
然后调用 start()方法，开启新的线程，执行run（）方法
1.自定义一个类 MyThread，继承java.lang包下的Thread类
2.重写run方法
3.将要在线程中执行的代码编写在run方法中
4.创建上面MyThread的对象
5.调用start方法启动线程

第二种：实现Runnable接口
子类实现runnable接口，直接调用run（）并不会创建新的线程，而且Runnable中没有start（）方法
因此必须也实例化Tread对象，并调用start（）方法。开启新的线程
1.自定义一个类实现java.lang包下的Runnable接口
2.重写run方法
3.将要在线程中执行的代码编写在run方法中
4.创建上面自定义类的对象
5.创建Thread对象并将上面自定义类的对象作为参数传递给Thread的构造方法
6.调用start方法启动线程

第三种：创建Thread内部类
 */
public class RunApplication {
    public static void main(String[] args) {

        // 第一种方式 实例化Thread子类 并调用start()方法 开启新的线程
        (new ThreadDemo()).start();

        // 第二种方式 实例化接口的实现类对象 将对象作为参数传递给Thread构造方法 并调用start()方法 开启新的线程
        (new Thread(new SubRunnable())).start();

        // 第三种方式 创建Thread内部类 重写run()方法
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000L);
                        System.out.println("...This is a new Thread from 'Thread内部类' ...");
                    } catch (Exception var2) {
                        var2.printStackTrace();
                    }
                }
            }
        };
        // 调用start()方法 开启新的线程
        thread.start();
    }
}


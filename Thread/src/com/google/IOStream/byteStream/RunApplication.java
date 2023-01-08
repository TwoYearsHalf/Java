package com.google.IOStream.byteStream;


import java.io.*;
import java.util.Date;

public class RunApplication {
    public static void main(String[] args) {

//        // 使用绝对路径创建文件对象
//        File file = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");
//
//        // 文件是否存在
//        System.out.println(file.exists());
//
//        // 文件是否为文件夹
//        System.out.println(file.isDirectory());
//
//        // 文件是否为文件
//        System.out.println(file.isFile());
//
//        // 文件的长度
//        System.out.println(file.length());
//
//        // 获取文件的最后修改时间
//        long time = file.lastModified();
//        Date date = new Date(time);
//        System.out.println("最后修改的时间为：" + date);
//
//        // 文件重命名
//        File file_1 = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");
//        file.renameTo(file_1);
//        System.out.println(file.getName());
//        System.out.println(file_1.getName());
//
//        // 以字符串数组的形式，返回当前文件夹下的所有文件(不包含子文件及子文件夹)
//        System.out.println(file.list());
//
//        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
//        File[] files = file.listFiles();
//
//        // 以字符串形式 返回获取所在文件夹
//        System.out.println(file.getParent());
//
//        // 创建文件夹，如果父文件夹不存在，创建就无效
//        file.mkdir();
//
//        // 创建文件夹，如果父文件夹不存在，就回创建父文件夹
//        file.mkdirs();
//
//        // 创建一个空文件夹，如果父文件夹不存在，就会抛出异常
//        try {
//            file.createNewFile();
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
//
//        // 所以创建一个空文件夹之前，都会创建父目录
//        file.getParentFile().mkdirs();
//
//        // 删除文件
//        file.delete();


        /*
        什么是输入流，输出流？
        输入输出都是相对于程序而言，
        将数据源中的数据读入到程序中---输入流(read)
        把程序的数据写到文件中---输出流(write)
         */

        /* 字节流
           InputStream字节输入流
           OutputStream字节输出流
           */
        //InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现
        //FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取

        File file = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");
        try {
            //创建基于文件的输入流
            FileInputStream fileInputStream = new FileInputStream(file);

            // 创建字节数组，长度就是文件的长度
            byte[] bytes = new byte[(int) file.length()];

            // 以字节流的形式，读取文件所有内容
            fileInputStream.read(bytes);

            // 用增强for循环打印
            for (byte b :
                    bytes) {
                System.out.println(b);
            }

            // 每次使用完流，应该关闭流
            fileInputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        // OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
        // FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
        try {
            File file_1 = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\2.txt");

            // 初始化一个字节数组
            byte[] byte_1 = new byte[]{12,3,4,5,6,7,7};

            // 创建基于文件的输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file_1);

            // 把数据写入到输出流
            fileOutputStream.write(byte_1);

            // 关闭流
            fileOutputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


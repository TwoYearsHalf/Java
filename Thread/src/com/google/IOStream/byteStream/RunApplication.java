package com.google.IOStream.byteStream;


import java.io.File;
import java.util.Date;

public class RunApplication {
    public static void main(String[] args) {

        // 使用绝对路径创建文件对象
        File file =new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");

        // 文件是否存在
        System.out.println(file.exists());

        // 文件是否为文件夹
        System.out.println(file.isDirectory());

        // 文件是否为文件
        System.out.println(file.isFile());

        // 文件的长度
        System.out.println(file.length());

        // 获取文件的最后修改时间
        long time = file.lastModified();
        Date date = new Date(time);
        System.out.println("最后的时间为：" + date);


    }
}

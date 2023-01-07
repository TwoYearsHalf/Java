package com.google.IOStream.byteStream;


import java.io.File;
import java.util.Date;

public class RunApplication {
    public static void main(String[] args) {

        // 使用绝对路径创建文件对象
        File file = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");

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
        System.out.println("最后修改的时间为：" + date);

        // 文件重命名
        File file_1 = new File("E:\\Project\\Git\\JavaThread\\Thread\\src\\com\\google\\IOStream\\1.txt");
        file.renameTo(file_1);
        System.out.println(file.getName());
        System.out.println(file_1.getName());

        // 以字符串数组的形式，返回当前文件夹下的所有文件(不包含子文件及子文件夹)
        System.out.println(file.list());

        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] files = file.listFiles();

        // 以字符串形式 返回获取所在文件夹
        System.out.println(file.getParent());

        // 创建文件夹，如果父文件夹不存在，创建就无效
        file.mkdir();

        // 创建文件夹，如果父文件夹不存在，就回创建父文件夹
        file.mkdirs();

        // 创建一个空文件夹，如果父文件夹不存在，就会抛出异常
        try {
            file.createNewFile();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        // 所以创建一个空文件夹之前，都会创建父目录
        file.getParentFile().mkdirs();

        // 删除文件
        file.delete();
        }
    }

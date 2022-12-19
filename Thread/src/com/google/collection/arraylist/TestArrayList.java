package com.google.collection.arraylist;


import java.util.ArrayList;

/* 容器类 ArrayList
容器的容量"capacity"会随着对象的增加，自动增长
 */
public class TestArrayList {
    public static void main(String[] args) {
     // 创建容器类
        ArrayList arrayList =new ArrayList();

        // 向容器中添加对象
        arrayList.add(new Human("Tom"));
        System.out.println("arrayList = " + arrayList.get(0));

        // 输出容器大小
        System.out.println(arrayList.size());

        // 向容器中添加对象
        arrayList.add(new Human("Jerry"));
        System.out.println("arrayList = " + arrayList.get(1));

        // 输出容器大小
        System.out.println(arrayList.size());
    }
}

package com.google.collection.arraylist;


import java.util.ArrayList;
import java.util.List;

/*
集合概述:
数组长度是固定的，如果要改变数组的长度需要通过数组拷贝的方式，使用起来不太方便。java给开发者提供了一些集合类，能够存储任意长度的对象数据，长度可以随着元素的增加而增加，随着元素的减少而减少，使用起来方便一些。集合的主要作用是存取数据，在实际应用中出现的频率非常多，因此集合非常重要。

容器类 ArrayList
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

        /*
        ArrayList实现了接口List
        常见的写法会把引用声明为接口List类型
        注意：是java.util.List,而不是java.awt.List
         */
        List list = new ArrayList();
        list.add(new Human("list"));
    }
}

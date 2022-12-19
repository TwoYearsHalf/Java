package com.google.collection.arralistmothed;

import com.google.collection.arraylist.Human;

import java.util.ArrayList;

public class RunApplication {
    public static void main(String[] args) {
        // 创建容器
        ArrayList arrayList = new ArrayList();

        // 1.add 有两种用法
        //第一种是直接add对象，把对象加在最后面
        for (int i = 0; i < 5; i++) {
            arrayList.add("Human " + i);
        }
        System.out.println("arrayList = " + arrayList);

        // 第二种是在指定位置加对象,
        // 如果输入的位置小于容器大小，它会把当前位置的对象挤到下一位
        arrayList.add(3, new Human("挤一下"));
        System.out.println("arrayList = " + arrayList);
        // 如果输入的位置等于容器大小，则直接放在最后一位
        arrayList.add(6, "这个最后一个");
        System.out.println("arrayList = " + arrayList);


        // 2.contains 判断是否存在
        // 判断标准： 是否是同一个对象，而不是name是否相同

        // 先创建一个特殊对象,没有加入到容器中
        Human specialHuman = new Human();

        // 此时，再创建一个对象并且 name 是 specialHuman，加入到容器中
        arrayList.add(new Human("specialHuman"));
        // 这时候判断：对象specialHuman是否在容器中
        System.out.println("false 就是不在里面喽 ————> "+ arrayList.contains(specialHuman));

        // 3.get 获取指定位置对象
        System.out.println(arrayList.get(3));

        // 4.indexOf 获取指定对象的位置
        System.out.println(arrayList.indexOf("Human 2"));

        // 5.remove 用于把对象从ArrayList中删除
        // remove可以根据下标删除ArrayList的元素
        arrayList.remove(3);
        System.out.println(arrayList);
        // 根据对象删除
        arrayList.remove("Human 0");
        System.out.println(arrayList);

        // 6.set 替换指定位置元素
        arrayList.set(0,new Human("顶一下"));
        System.out.println(arrayList);

        // 7.size 获取ArrayList容器大小
        System.out.println(arrayList.size());

        // 测试
    }
}

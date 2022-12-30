package com.google.collection.traverse;

import com.google.collection.generic.Animal;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
        ArrayList<Animal> arrayList = new ArrayList<>();

        // 放5个Animal进入容器
        // 普通for循环
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Animal("animal " + i));
        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            Animal animal = arrayList.get(i);
//            System.out.println(animal);
//        }

        // 增强for循环
        for (Animal animal :
                arrayList) {
            System.out.println(animal);
        }
    }
}

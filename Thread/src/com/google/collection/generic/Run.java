package com.google.collection.generic;
/*
不使用泛型带来的问题
Cat Dog 都是Animal的子类
ArrayList 默认接受Object类型的对象，所以所有对象都可以放进ArrayList中
所以get(0) 返回的类型是Object
接着，需要进行强制转换才可以得到APHero类型或者ADHero类型。
如果软件开发人员记忆比较好，能记得哪个是哪个，还是可以的。 但是开发人员会犯错误，比如第20行，会记错，把第0个对象转换为Cat,这样就会出现类型转换异常
 */

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        // 不使用泛型
        List list = new ArrayList();

        // 容器中第0个数据是Cat类型
        list.add(new Cat("Tom"));

        // 容器中第1个数据是Dog类型
        list.add(new Dog("Jerry"));

        // 第0个数据给了cat对象，类型一致
        Cat cat =(Cat) list.get(0);

        // 第1个数据给了dog对象，类型一致
        Dog dog =(Dog) list.get(1);

        // 这样会出错
//        Dog dog_1 = (Dog)list.get(0);


        // 使用泛型
        /*
        使用泛型的好处：
        泛型的用法是在容器后面添加<Type>
        Type可以是类，抽象类，接口
        泛型表示这种容器，只能存放Dog，Cat就放不进去了
         */
        // 该容器被设置为只能装Dog类的对象
        List<Dog> list_1 =new ArrayList<>();
        list_1.add(new Dog());

        // 同时，获取容器中的数据也不用进行类型转换
        Dog dog_1 = list_1.get(0);

        // 如果容器的泛型是Animal 那么Animal的子类都可以放进去
        ArrayList<Animal> arrayList = new ArrayList<>();
        arrayList.add(new Cat());
        arrayList.add(new Dog());
    }
}

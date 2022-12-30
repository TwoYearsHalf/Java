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
//        List list = new ArrayList();

        // 容器中第0个数据是Cat类型
//        list.add(new Cat("Tom"));

        // 容器中第1个数据是Dog类型
//        list.add(new Dog("Jerry"));

        // 第0个数据给了cat对象，类型一致
//        Cat cat = (Cat) list.get(0);

        // 第1个数据给了dog对象，类型一致
//        Dog dog = (Dog) list.get(1);

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
//        List<Dog> list_1 = new ArrayList<>();
//        list_1.add(new Dog());

        // 同时，获取容器中的数据也不用进行类型转换
//        Dog dog_1 = list_1.get(0);

        // 如果容器的泛型是Animal 那么Animal的子类都可以放进去
//        ArrayList<Animal> arrayList = new ArrayList<>();
//        arrayList.add(new Cat());
//        arrayList.add(new Dog());


        //  ? extends
        /*
        ArrayList animalList<? extends Animal> 表示这是一个Animal泛型或者其子类泛型
        animalList 的泛型可能是Animal
        animalList 的泛型可能是Dog
        animalList 的泛型可能是Cat
        所以 可以确凿的是，从animalList取出来的对象，一定是可以转型成Animal的

        但是，不能往里面放东西，因为
        放Cat就不满足<Dog>
        放Dog又不满足<Cat>
         */
        ArrayList<? extends Animal> animalList = new ArrayList<>();
        ArrayList<Dog> dogArrayList = new ArrayList<>();
        dogArrayList.add(new Dog("Jerry"));
        animalList = dogArrayList;

        // 可以取东西
        Animal animal = animalList.get(0);

        // 但是 不能往里面放东西
        // 报错
//        animalList.add(new Dog("laji"));


        // ? super
        /*
        ArrayList animalList<? super Animal> 表示这是一个Hero泛型或者其父类泛型
        animalList的泛型可能是Animal
        animalList的泛型可能是Object

        可以往里面插入Animal以及Animal的子类
        但是取出来有风险，因为不确定取出来是Animal还是Object
         */
        ArrayList<Animal> animalArrayList = new ArrayList<>();

        // 可以插入数据
        animalArrayList.add(new Animal());
        // 也可以插入其子类
        animalArrayList.add(new Dog());

        // 但是不可以读取，因为有可能读取的泛型是Object，强制转换会失败
        // 报错
//        Dog dog = animalArrayList.get(0);


        // 泛型通配符 ?
       /*
       泛型通配符? 代表任意泛型
        既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能

        所以只能以Object的形式取出来
        并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
        */
        ArrayList<?> arrayList = new ArrayList<>();
        arrayList = animalArrayList;

        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object object = arrayList.get(0);

        //  ?的缺陷2:既然？代表任意泛型，那么极有可能是Animal，也有可能是Dog
        // 所以，放哪种对象进去，都有哦风险，结果就什么类型的对象，都不能放进去
        // 报错
//        arrayList.add(new Dog());
//        arrayList.add(new Cat());
    }
}

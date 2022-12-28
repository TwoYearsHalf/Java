package com.google.collection.generic;

public class Animal {

    public String name;
    public int age;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

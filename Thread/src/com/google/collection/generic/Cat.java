package com.google.collection.generic;

public class Cat extends Animal{
    public String name;

    public Cat(){}
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat[" +
                "name='" + name + '\'' +
                ']';
    }
}

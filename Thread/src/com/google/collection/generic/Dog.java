package com.google.collection.generic;

public class Dog extends Animal {
    public String name;

    public Dog(){}
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog[" +
                "name='" + name + '\'' +
                ']';
    }
}


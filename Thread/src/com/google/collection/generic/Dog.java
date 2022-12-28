package com.google.collection.generic;

public class Dog extends Animal {
    public String name;

    public Dog(){}
    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, String name1) {
        super(name);
        this.name = name1;
    }

    @Override
    public String toString() {
        return "Dog[" +
                "name='" + name + '\'' +
                ']';
    }
}


package com.himedia.java;

public class F_person3 {

    String name;
    int age;

    public F_person3() {}

    public F_person3(String name) {
        this.name = name;
    }

    public F_person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + " Age: " + age);
    }

}

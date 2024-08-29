package com.himedia.java;

public class F_person4 {
    String name;
    int age;

    public F_person4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 복사 생성자
    public F_person4(F_person4 other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name + " Age: " + age);
    }
}

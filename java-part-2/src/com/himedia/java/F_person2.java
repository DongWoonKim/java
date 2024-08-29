package com.himedia.java;

public class F_person2 {

    String name;
    int age;

    // 매개변수가 있는 생성자
    public F_person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name : " + name + " Age : " + age);
    }
}

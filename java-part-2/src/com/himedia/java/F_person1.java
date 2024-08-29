package com.himedia.java;

public class F_person1 {
    String name;
    int age;
    
    // 기본 생성자
    public F_person1() {
        this.name = "Unknown";
        this.age = 0;
    }

    public void display() {
        System.out.println("Name : " + this.name + " Age : " + this.age);
    }

}

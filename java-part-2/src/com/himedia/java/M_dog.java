package com.himedia.java;

public class M_dog implements M_animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍멍~~~");
    }

    @Override
    public void eat() {
        System.out.println("우걱우걱우걱~~~");
    }
}

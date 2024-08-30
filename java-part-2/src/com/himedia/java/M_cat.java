package com.himedia.java;

public class M_cat implements M_animal {
    @Override
    public void makeSound() {
        System.out.println("야옹야옹야옹~~~~");
    }

    @Override
    public void eat() {
        System.out.println("뇸뇸뇸~~~~");
    }
}

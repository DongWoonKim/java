package com.himedia.java;

public class G_dog extends G_animal {

    public void bark() {
        System.out.println(name + " is barking.");
    }

    @Override
    public void walk() {
        System.out.println("우당탕탕~");
    }
}

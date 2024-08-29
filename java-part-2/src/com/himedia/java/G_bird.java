package com.himedia.java;

public class G_bird extends G_animal {

    String wing;

    public void fly() {
        System.out.println(name + " is flying using " + wing);
    }

    @Override
    public void walk() {
        System.out.println("사뿐사뿐~~~");
    }
}

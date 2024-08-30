package com.himedia.java;

public class I_child extends I_parent {

    int y = 30;
    int z = 40;

    @Override
    public String getLocation() {
        return super.getLocation() + ", z=" + z;
    }

    public void method() {
        System.out.println("x=" + x);
        System.out.println("this.x=" + this.x);
        System.out.println("super.x=" + super.x);

        System.out.println("y=" + y);
        System.out.println("this.y=" + this.y);
        System.out.println("super.y=" + super.y);
    }
}

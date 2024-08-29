package com.himedia.java;

public class D_calc {
    // 정적 변수    
    public static final double PI = 3.14159;
    
    // 정적 메서드
    public static double add(double a, double b) {
        return a + b;
    }

    public static double multi(double a, double b) {
        return a * b;
    }

    public static double circleArea(double radius) {
        return PI * radius * radius;
    }

}

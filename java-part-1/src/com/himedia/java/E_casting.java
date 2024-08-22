package com.himedia.java;

// * 형변환
// 변수 또는 상수의 타입을 다른 타입으로 변환하는 것.
// 기본형에서 boolean을 제외한 나머지 타입들은 서로 형변환이 가능하다.

// * 암시적(자동) 형변환과 명시적(강제) 형변환이 있다.
// 암시적 형변환은 더 작은 자료형으로 변환될 때 자동으로 이루어지며,
// 명시적 형변환은 반대로 더 큰 자료형을 더 작은 자료형으로 변환할 때 명시적으로 해야 한다.

// * 암시적 형변환 순서 (작은크기 -> 큰크기)
// 1. byte -> short -> int -> long -> float -> double
// 2. char -> int -> long -> float -> double
// 이 순서대로 자료형이 자동으로 변환될 수 있으며, 변환 중 데이터 손실이 없거나 적은 경우에 암시적 형변환이 이루어진다.

public class E_casting {
    public static void main(String[] args) {

        // double -> int
        double d = 3.14;
        System.out.println(d);
        int score = (int)d;
        System.out.println(score);

        // int -> char
        int a = 65;
        System.out.println(a);
        char ch = (char)a;
        System.out.println(ch);

        // char -> int
        char ch2 = 'A';
        System.out.println(ch2);
        int a2 = ch2;
        System.out.println(a2);

        // float -> int
        int n = 3;
        System.out.println(n);
        float f = n;
        System.out.println(f);

        // 암시적 형변환
        byte b = 10;
        int i = b;
        System.out.println(i);

        int k = 100;
        double d2 = k;
        System.out.println(d2);

    }

}

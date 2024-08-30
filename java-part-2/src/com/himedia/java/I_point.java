package com.himedia.java;

public class I_point {

    int x = 10;
    int y = 20;

    public I_point(int x, int y) {
        // 생성자 첫 줄에서 다른 생성자를 호출하지 않기 때문에
        // 컴파일러가 super()를 여기에 삽입한다.
        // super()는 Point의 조상인 Object클래스의 기본 생성자인 Object()를 의미한다.
        System.out.println("나는 부모이다.");
        this.x = x;
        this.y = y;
    }
}

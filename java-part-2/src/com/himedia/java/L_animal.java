package com.himedia.java;

public abstract class L_animal {
    // 추상 메서드 : 하위 클래스가 이 메서드를 구현해야함
    public abstract void makeSound();
    
    // 일반 메서드
    public void breathe() {
        System.out.println("동물은 숨을 쉰다.");
    }
}

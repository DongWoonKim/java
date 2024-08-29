package com.himedia.java;

public class A_tv {
    // 속성 -> 필드, 멤버 변수
    String color;
    boolean power;
    int volume;
    int channel;
    
    // 생성자 : 객체가 생성될 때, 최초 한번만 실행되는 메서드 -> 값을 초기화..
    public A_tv() {
        System.out.println("초기화 진행 시작");
        this.color = "black";
        this.power = false;
        this.volume = 10;
        this.channel = 3;
        System.out.println("초기화 종료");
    } 
    
    // 기능(함수) -> 메서드
    public void power() {
        power = !power;
        System.out.println("TV 전원을 " + (power ? "켰다" : "껐다"));
    }

    public void volumeUp() {
        volume++;
        System.out.println("볼륨을 올렸다 " + volume);
    }

    public void volumeDown() {
        volume--;
        System.out.println("볼륨을 내렸다 " + volume);
    }

    public void channelUp() {
        channel++;
        System.out.println("채널을 올렸다 " + channel);
    }

    public void channelDown() {
        channel--;
        System.out.println("채널을 내렸다 " + channel);
    }

    public void getColor() {
        System.out.println("TV Color는 " + color);
    }
}

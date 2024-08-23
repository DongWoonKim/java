package com.himedia.java;

import java.util.Scanner;

// * 조건문
// 조건식의 연산결과에 따라 실행할 문장이 프로그램의 실행흐름을 바꿀 수 있다.
public class G_if_switch {

    // 1) if문
    public static void exam1() {
        int score = 90;

        if ( score >= 90 ) {
            System.out.println("A학점 입니다.");
        }
    }

    // 1-1) if - else
    public static void exam2() {
        int score = 90;

        if ( score >= 60 ) {
            System.out.println("합격입니다.");
        } else {
            System.out.println("불합격입니다.");
        }
    }

    // 1-2) if - else if - else
    public static void exam3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요.");
        int score = sc.nextInt();

        if ( score >= 90 ) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

    }

    // 1-3) 중첩 if
    public static void exam4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요.");
        int score = sc.nextInt();

        if ( score >= 90 ) {
            if (score >= 95) {
                System.out.println("A++");
            } else {
                System.out.println("A");
            }
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }

    // 2) switch
    // - switch문의 조건식은 결과값이 반드시 정수 또는 문자열이어야 한다.
    // - case문의 값은 정수 상수만 가능하며, 중복되지 않아야 한다.
    public static void exam5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("음료수 번호를 입력하세요");
        System.out.println("[1]콜라 [2]사이다 [3]환타 [4]물");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("콜라가 나왔습니다.");
                break;
            case 2:
                System.out.println("사이다가 나왔습니다.");
                break;
            case 3:
                System.out.println("환타가 나왔습니다.");
                break;
            case 4:
                System.out.println("물이 나왔습니다.");
                break;
            default:
                System.out.println("잘 못 누르셨습니다.");
        }

    }

    public static void exam6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1~12월 중 하나를 입력하세요.");
        int month = sc.nextInt();

        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("1분기 입니다.");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("2분기 입니다.");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("3분기 입니다.");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("4분기 입니다.");
                break;
        }

    }

    public static void main(String[] args) {
        exam3();
    }

}

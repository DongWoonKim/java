package com.himedia.java;

import java.util.Scanner;

public class D_scanner_print {

    public static void main(String[] args) {

        String name = "홍길동";
        System.out.printf("이름 : %s \n나이 : %d \n", name, 25);

        int age = 25;
        System.out.printf("나이 : %d\n", age);
        System.out.println("나이 : " + age);

        System.out.printf("[자기소개]\n안녕하세요!\n만나서 반갑습니다.\n");

        System.out.println("당신의 이름은 무엇입니까?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.printf("제 이름은 %s 입니다.\n", userName);
        System.out.print("그럼 나이가 어떻게 되시나요?");
        int userAge = sc.nextInt();
        System.out.printf("제 나이는 %d 입니다.", userAge);

    }

}

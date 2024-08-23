package com.himedia.java;

import java.util.Scanner;

public class I_vending_machine {

    static final int COKE = 500, CIDER = 700, FANTA = 300, WATER = 200;

    public static void printMenu(int totalMoney) {
        System.out.println("====================== 자판기 ======================");
        System.out.println("[1]콜라-500원 [2]사이다-700원 [3]환타-300원 [4]물-200원");
        System.out.println("[5]돈넣기 [6]반환");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("===================================================");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 메뉴를 선택하시오 -> ");

        return sc.nextInt();
    }

    public static int getMoney() {
        // 돈을 넣으시오.
        Scanner sc = new Scanner(System.in);
        System.out.print("돈을 넣으시오 -> ");
        return sc.nextInt();
    }

    public static int calcMoney(int totalMoney, int price) {
        return totalMoney - price;
    }

    public static void printException() {
        System.out.println("잔돈이 부족합니다.");
    }

    public static void main(String[] args) {
        int totalMoney = 0;

        while (true) {
            printMenu(totalMoney);
            int myChoice = getChoice();
            int result = -1;
            switch (myChoice) {
                case 1:
                    result = calcMoney(totalMoney, COKE);
                    if ( result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("콜라가 나왔습니다.");
                    }
                    break;
                case 2:
                    result = calcMoney(totalMoney, CIDER);
                    if ( result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;
                case 3:
                    result = calcMoney(totalMoney, FANTA);
                    if ( result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;
                case 4:
                    result = calcMoney(totalMoney, WATER);
                    if ( result < 0 ) {
                        printException();
                    } else {
                        totalMoney = result;
                        System.out.println("물이 나왔습니다.");
                    }
                    break;
                case 5:
                    // getMoney
                    totalMoney += getMoney();
                    break;
                case 6:
                    System.out.printf("잔돈 : %d원이 반환되었습니다.", totalMoney);
                    return;
                default:
                    System.out.println("잘 못 누르셨습니다.");
            }
        }

    }
}

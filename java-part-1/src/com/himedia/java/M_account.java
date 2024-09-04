package com.himedia.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class M_account {
    public static final int ACCOUNT_MAX_LENGTH = 5;
    public static final int HISTORY_MAX_SIZE = 5;

    public static String userAccount;
    public static String userName;
    public static int totalMoney;

    public static String[] histories = new String[HISTORY_MAX_SIZE];
    public static int historyIdx = -1;

    public static void printCreateAccountMenu() {
        System.out.println("============== 계좌생성 ==============");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        userName = sc.nextLine();
        userAccount = createAccountNum();

        System.out.println("계좌가 생성되었습니다. [이름] " + userName + ", [계좌번호] " + userAccount);
    }

    public static String createAccountNum() {
        StringBuilder result = new StringBuilder();
        int[] accountNums = new int[ACCOUNT_MAX_LENGTH];
        int idx = 0;
        while (idx < accountNums.length) {
            int tmp = (int)(Math.random() * 10);

            if ( idx == 0 && tmp == 0 ) continue;
            if ( idx > 0 ) {
                if ( checkDuplicateNum(accountNums, tmp, idx) ) continue;
            }

            accountNums[idx++] = tmp;
        }

        for ( int accountNum : accountNums ) {
            result.append(accountNum);
        }

        return result.toString();
    }

    public static boolean checkDuplicateNum(int[] accountNums, int tmp, int idx) {
        for (int i = 0; i < idx; i++) {
            if (tmp == accountNums[i]) {
                return true;
            }
        }

        return false;
    }

    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ 메뉴 ============");
        System.out.println("[계좌번호] : " + userAccount + ", [이름] " + userName);
        System.out.println("[1]입금 [2]출금 [3]내역조회 [4]프로그램 종료");
        System.out.println("현재금액 - " + totalMoney + "원");
        System.out.println("원하시는 메뉴를 선택하세요.");

        return sc.nextInt();
    }

    public static void addMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금할 금액을 입력하세요.");
        int getMoney = sc.nextInt();
        totalMoney += getMoney;

        // 히스토리 추가
        String historyMessage= "[입금] " + getMoney + "원 ";
        manageHistory(historyMessage);
    }

    public static void manageHistory(String message) {
        historyIdx++;
        if (historyIdx >= HISTORY_MAX_SIZE) {
            for (int i = 0; i < HISTORY_MAX_SIZE - 1; i++) {
                histories[i] = histories[i + 1];
            }
            historyIdx = HISTORY_MAX_SIZE - 1;
        }
        histories[historyIdx] = message + " - " + getNowDateTime();
    }

    public static void printHistory() {
        System.out.println("======== 내역조회 ========");
        for ( int i = historyIdx; i >= 0; i-- ) {
            if (histories[i] == null) continue;
            System.out.println(histories[i]);
        }
    }

    public static void subMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금할 금액을 입력하세요.");
        int subMoney = sc.nextInt();
        if (subMoney > totalMoney) {
            System.out.println("출금할 금액이 부족합니다.");
            return;
        }
        totalMoney -= subMoney;

        // 히스토리 추가
        String historyMessage= "[출금] " + subMoney + "원 ";
        manageHistory(historyMessage);
    }

    public static String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static void main(String[] args) {
        printCreateAccountMenu();

        while (true) {
            int choice = printMenu();
            switch (choice) {
                case 1:
                    addMoney();
                    break;
                case 2:
                    subMoney();
                    break;
                case 3:
                    printHistory();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
            }
        }

    }
}

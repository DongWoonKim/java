package com.himedia.practice;

import java.util.Scanner;

public class M_account {

    public static final int ACCOUNT_MAX_LENGTH = 5;

    public static String userName;
    public static String userAccount;

    public static void printCreateAccountMenu() {
        System.out.println("===========계좌 생성===========");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");

        userName = sc.nextLine();
        userAccount = createAccountNum();

        System.out.println("계좌가 생성되었습니다. [이름] " + userName + ", [계좌번호] " + userAccount);
    }

    public static String createAccountNum() {
        StringBuilder sb = new StringBuilder();
        int[] accountNums = new int[ACCOUNT_MAX_LENGTH];
        int idx = 0;

        while (idx < ACCOUNT_MAX_LENGTH) {
            int tmp = (int)(Math.random() * 10);

            if ( idx == 0 && tmp == 0 ) continue;
            if ( idx > 0 && checkDuplicateNum(accountNums, tmp, idx) ) continue;

            accountNums[idx++] = tmp;
        }

        for ( int accountNum : accountNums ) {
            sb.append(accountNum);
        }

        return sb.toString();
    }

    public static boolean checkDuplicateNum(int[] accountNums, int tmp, int idx) {
        for (int i = 0; i < idx; i++) {
            if (accountNums[i] == tmp) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printCreateAccountMenu();
    }

}

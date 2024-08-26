package com.himedia.java;

// * 다차원 배열
// * 2차원 배열
// 타입[][] 변수이름 = new 타입[길이][길이];

public class J_array_2 {

    public static void exam1() {
        int[][] score = new int[3][2];
        score[0][0] = 1;
        score[0][1] = 2;
        score[1][0] = 3;
        score[1][1] = 4;
        score[2][0] = 5;
        score[2][1] = 6;

        for ( int row = 0; row < score.length; row++ ) {
            for ( int col = 0; col < score[row].length; col++ ) {
                System.out.print(score[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void exam2() {
        int[][] score = {{1, 2}, {3, 4}, {5, 6}};

        for ( int[] sc : score ) {
            System.out.println(sc);
            for ( int s : sc) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    // * 가변 배열
    // 2차원 이상의 다차원 배열을 생성할 때 전체 배열 차수 중
    // 마지막 차수의 길이를 지정하지 않고, 추후에 각기 다른
    // 길이의 배열을 생성함으로써 고정된 형태가 아닌 보다 유동적인
    // 가변 배열을 구성할 수 있다.
    public static void exam3() {
        int[][] score = new int[3][];

        score[0] = new int[]{1, 2};
        score[1] = new int[3];
        score[2] = new int[4];

        score[1][0] = 3;
        score[1][1] = 4;
        score[1][2] = 5;

        score[2][0] = 6;
        score[2][1] = 7;
        score[2][2] = 8;
        score[2][3] = 9;

        for ( int row = 0; row < score.length; row++ ) {
            for ( int col = 0; col < score[row].length; col++ ) {
                System.out.print(score[row][col] + " ");
            }
            System.out.println();
        }

    }

    // * 3차원 배열
    public static void exam4() {
        int[][][] score = new int[3][3][3];
        int[][][] score2 = new int[3][3][];
    }

    public static void main(String[] args) {
        exam3();
    }

}

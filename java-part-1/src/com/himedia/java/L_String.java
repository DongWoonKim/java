package com.himedia.java;

// * String 클래스
// - 불변성(Immutable)
// String 객체가 생성되면 그 객체의 문자열 값은 변경할 수 없다.
// - 메모리 효율성
// 같은 값을 가진 String 값은 메모리에서 공유된다.
// 이는 메모리 사용을 줄이고, 성능을 향상시킨다.

public class L_String {

    // 1. charAt(int index)
    // 설명 : 문자열에서 특정 위치에 있는 문자(char)를 반환한다.
    // 활용 : 문자열의 각 문자를 순회하거나 특정 위치의 문자를 비교할 때 유용하다.
    public static void exam1() {
        String str = "Hello";
        for ( int i = 0; i < str.length(); ++i ) {
            char c = str.charAt(i);
            System.out.println(c);
        }
    }

    // 2. substring(int beginIndex, int endIndex)
    // 설명 : 문자열의 특정 부분을 추출하여 반환한다.
    // 활용 : 문자열의 일부를 분리하거나, 특정 패턴을 추출할 때 사용한다.
    public static void exam2() {
        String str = "Hello";
        String sub = str.substring(0, 3);
        System.out.println(sub);
        // 20240826
        // 출력 : 년 월 일을 쪼개서 출력할 것.
        // 2024
        // 08
        // 26
        String full = "20240826";
        String year = full.substring(0, 4);
        String month = full.substring(4, 6);
        String day = full.substring(6, 8);
    }

    // 3. split(String regex)
    // 설명 : 주어진 정규 표현식을 기준으로 문자열을 분리하여 배열을 반환한다.
    // 활용 : 문자열을 특정 구분자로 분리하여 여러 부분으로 나눌 때 유용하다.
    public static void exam3() {
        String str = "one two three four";
        String[] strs = str.split(" ");
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        System.out.println(strs[2]);
        System.out.println(strs[3]);

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    // 4. toCharArray()
    // 설명 : 문자열을 문자 배열로 반환한다.
    // 활용 : 문자열을 배열처럼 다루고 싶을 때 유용하며,
    // 특히 for-each 문을 통해 문자열의 각 문자를 순회할 수 있다.
    public static void exam4() {
        String str = "Hello";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        for (char c : chars) {
            System.out.println(c);
        }

    }

    // 5. equals(String anotherString)
    // 설명 : 두 문자열의 값을 비교하여 같으면 true, 다르면 false를 반환한다.
    // 활용 : 문자열 비교에서 자주 사용한다.
    public static void exam5() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "def";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }

    public static void main(String[] args) {
        exam4();
    }
}

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

    // 6. contains(CharSequence s)
    // 설명 : 문자열이 특정 문자열을 포함하고 있는지 확인한다.
    // 활용 : 문자열 내 특정 패턴이나 부분 문자열이 존재하는지 확인할 때 사용한다.
    public static void exam6() {
        String str = "Hello World!";
        boolean result = str.contains("World");
        System.out.println(result);
    }

    // 7. replace
    // 설명 : 문자열 내의 특정 문자 또는 문자열을 다른 문자열로 대체한다.
    // 활용 : 문자열 변환 문제나 패턴 치환 문제에서 유용하다.
    public static void exam7() {
        String str = "hello";
        String newStr = str.replace('l', 'p');
        System.out.println(newStr);
    }

    // 8. indexOf(String str), lastIndexOf(String str)
    // 설명 : 특정 문자열이 처음 또는 마지막으로 나타나는 위치를 반환한다.
    // 활용 : 특정 패턴이나 부분 문자열의 위치를 찾을 때 사용한다.
    public static void exam8() {
        String str = "hello";
        int idx = str.indexOf("l");
        System.out.println(idx);
        idx = str.lastIndexOf("l");
        System.out.println(idx);
    }

    // 9. StringBuilder, StringBuffer
    // 설명 : StringBuilder와 StringBuffer는 가변(mutable) 문자열을 다루기 위한 클래스이다.
    // StringBuilder는 성능이 우수하며, StringBuffer는 스레드 안전한 버전이다.
    // 활용 : 반복적인 문자열 수정이 필요한 문제에서 성능을 최적화하기 위해 사용한다.
    public static void exam9() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World");
        String result = sb.toString();
        System.out.println(result);
    }

    // 10. reverse()
    // 설명 : 문자열을 뒤집는다. String 자체에는 reverse()메서드가 없지만,
    // StringBuilder를 사용하여 문자열을 뒤집을 수 있다.
    // 효과 : 문자열을 뒤집는 문제에서 자주 사용된다.
    public static void exam10() {
        String str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        System.out.println(reversed);

        System.out.println(
                new StringBuilder(str).reverse()
        );
    }

    // 11. compareTo(String anotherString)
    // 설명 : 두 문자열을 사전적으로 비교하여,
    // 현재 문자열이 더 작으면 음수, 같으면 0, 더 크면 양수를 반환한다.
    // 효과 : 문자열 정렬, 사전 순 비교, 순위 매기기 등에서 유용하다.
    public static void exam11() {
        String str1 = "apple";
        String str2 = "banana";
        int result = str1.compareTo(str2);
        System.out.println(result);
    }

    // 12. toLowerCase() 및 toUpperCase()
    // 설명 : 문자열을 소문자 또는 대문자로 변환한다.
    // 효과 : 대소문자 구분 없이 문자열을 비교하거나 특정 형식으로 변환할 때 사용한다.
    public static void exam12() {
        String str = "Hello World!";
        String lower = str.toLowerCase();
        String upper = str.toUpperCase();
        System.out.println(lower);
        System.out.println(upper);
    }

    public static void main(String[] args) {
        exam12();
    }
}

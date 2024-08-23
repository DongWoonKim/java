package com.himedia.java;

// * 연산자
// - 산술연산자 : +, -, *, /, %
// - 단항연산자 : ++, --
// - 비교연산자 : >, <, =>, =<, ==, !=
// - 논리연산자 : &&, ||, !, &, |, ^, ~
// - 대입연산자 : =
// - 기타 : ? :, 복합대입연산자

// * 연산자의 우선순위
// 곱셈과 누눗셈은 덧셈과 뺄셈보다 우선 순위가 높다.

public class F_operator {
    // [산수 연산자]
    public static void exam1() {
        int a = 10;
        int b = 4;

        System.out.printf("%d + %d = %d\n", a, b, a + b);
        System.out.printf("%d - %d = %d\n", a, b, a - b);
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        System.out.printf("%d / %d = %d\n", a, b, a / b);
        System.out.printf("%d / %d = %f\n", a, b, a / (double)b);
        System.out.printf("%d %% %d = %d\n", a, b, a % b);
    }

    // [단항연산자]
    public static void exam2() {
        // 증감 연산자 : 피연산자의 값을 1 증가시킨다.
        // i = i + 1, i += 1
        int i = 5;
        System.out.println("==== 증감 ====");
        System.out.println("전위형 : " + ++i); // -> 6
        System.out.println("후위형 : " + i++); // -> 6
        System.out.println("결과 : " + i); // -> 7

        // 감소 연산자 : 피연산자의 값을 1 감소시킨다.
        i = 5;
        System.out.println("==== 감소 ====");
        System.out.println("전위형 : " + --i); // -> 4
        System.out.println("후위형 : " + i--); // -> 4
        System.out.println("결과 : " + i); // -> 3

        i = i + 1;
        i -= 1;
        i += 4;
    }

    // [비교연산자]
    public static void exam3() {
        System.out.printf("10 == 10.0f \t%b\n", 10 == 10.0f);
        System.out.printf("'0' == 0 \t%b\n", '0' == 0);
        System.out.printf("'A' == 65 \t%b\n", 'A' == 65);
        System.out.printf("'A' > 'B' \t%b\n", 'A' > 'B');
        System.out.printf("'A' + 1 != 'B' \t%b\n", 'A' + 1 != 'B');
    }

    // [문자열 비교]
    // 두 문자열을 비교할 때는 비교 연산자 '==' 대신 equals()라는 메서드를 사용해야한다.
    public static void exam4() {
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        String str3 = "Hello";
        String str4 = "Hello";

        System.out.println(str3 == str4);
    }

    // [논리 연산자]
    // && : 그리고(AND) - 모두 true일 때 true
    // || : 또는(OR) - 둘 중 하나만 true이면 true
    // ! : 논리 부정 연산 - x가 true일 때 false
    public static void exam5() {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        System.out.println("a && b : " + (a && b));
        System.out.println("a || b : " + (a || b));
        System.out.println("a && c : " + (a && c));
        System.out.println("!a : " + !a);
    }

    // [비트연산자]
    // |(OR 연산자) : 피연산자 중 한 쪽의 값이 1이면, 1을 결과로 얻는다. 그 외에는 0
    // &(AND 연산자) : 피연산자 중 양 쪽이 모두 1이어야만 1을 결과로 얻는다. 그 외에는 0
    // ^(XOR 연산자) : 피연산자의 값이 서로 다를 때만 1을 결과로 얻는다. 같을 때는 0
    public static void exam6() {

        // ** 8진수 표현
        int octalNum = 0123;
        System.out.println(octalNum);

        // ** 16진수 표현
        int hexNum = 0xF;
        System.out.println(hexNum);

        // %X : 대문자 16진수 출력
        // %#X : 대문자 16진수로 출력하면서 0x 접두사를 추가 (0XFF)
        int x = 0xAB, y = 0xF;
        System.out.printf("x = %#X \t\t%s\n", x, toBinaryString(x));
        System.out.printf("y = %#X \t\t%s\n", y, toBinaryString(y));
        int result = x & y;
        System.out.printf("& : %s\n ", toBinaryString(result));
        result = x | y;
        System.out.printf("| : %s\n ", toBinaryString(result));
        result = x ^ y;
        System.out.printf("^ : %s\n ", toBinaryString(result));

    }

    public static String toBinaryString(int value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(" ", "0");
    }

    // [쉬프트 연산자]
    // 자바에서 쉬프트 연산자는 비트 단위로 이동시키는 연산을 수행한다.
    // 쉬프트 연산자는 크게 세 가지가 있으며, 각각의 역할과 사용법은 다음과 같다.
    // 1. 왼쪽 쉬프트 연산자 (<<)
    // 동작 : 지정된 비트 수만큼 왼쪽으로 비트를 이동시킨다. 왼쪽으로 이동한 빈 자리는 0으로 채워진다.
    // 사용법 : value << n 은 value의 비트를 n만큼 왼쪽으로 이동시킨다.
    // 효과 : 숫자를 2의 n제곱으로 곱하는 것과 같다.
    // 2. 오른쪽 쉬프트 연산자 (>>)
    // 동작 : 지정된 비트 수만큼 오른쪽으로 비트를 이동시킨다. 오른쪽으로 이동한 빈 자리는 원래 값의
    // 부호 비트로 채워진다.(부호 있는 오른쪽 쉬프트)
    // 사용법 : value >> n는 value의 비트를 n만큼 오른쪽으로 이동시킨다.
    // 효과 : 숫자를 2의 n제곱으로 나누는 것과 동일하다.(부호가 유지된다)
    // 3. 부호 없는 오른쪽 쉬프트 연산자(>>>)
    // 동작 : 지정된 비트 수만큼 오른쪽으로 비트를 이동시킨다. 오른쪽으로 이동한 빈 자리는 0으로 채워진다.
    // 이 연산은 부호 비트를 무시하고, 양수로만 취급한다.
    // 사용법 : value >>> n는 value의 비트를 n만큼 오른쪽으로 이동시킨다.
    // 효과 : 부호 없는 비트 이동이 필요할 때 사용된다.
    public static void exam7() {
        // 1.
        int value = 3;
        int result = value << 2;
        System.out.println(result);

        // 2.
        value = -8; // -8은 2진수로 1111 1000 (32비트로 표현할 때)
        result = value >> 2; // 오른쪽으로 2비트 이동 : 1111 1110
        System.out.println(result); // 출력 : -2 (부호 있는 비트가 유지됨).

        // -> 2의 보수 : -8의 2진수
        // 8을 2진수로 변환 : 0000 1000
        // 1의 보수로(반전) : 1111 0111
        // 2의 보수로(1의 보수에서 1을 더한 값) : 1111 0111 + 0000 0001 = 1111 1000

        // -> -8의 이진수를 다시 10진수로
        // 2의 보수의 2진수를 다시 1의 보수로 : 1111 1000 - 0000 0001 = 1111 0111
        // 1의 보수를 원래 수로 변환 : 0000 1000 -> 8
        // 1의 보수에서 2로 변환했기 때문에 음수이다. -> -8

        // 3.
        value = -8; // -8은 2진수로 1111 1000
        result = value >>> 2; // 오른쪽으로 2비트 이동 : 0011 1110
        System.out.println(result); // 출력 : 1073741822
    }

    // * 삼항연산자
    // 조건식 ? 참 : 거짓
    public static void exam8() {
        int x = 10, y = 5;
        boolean result = x < y ? true : false;
        System.out.println(result);

        String str = null;
//        str = "Hello";
        String resultStr = str == null ? "빈 문자열 입니다." : str;
        System.out.println(resultStr);
    }

    // 복합 대입 연산자
    // +=, -=, *=, /=, %=
    public static void exam9() {
        int num = 5;
        num += 1; // num = num + 1;
        System.out.println(num);
        num -= 2;
        System.out.println(num);
        num /= 2; // num = num / 2;
        System.out.println(num);
        num *= 2;
        System.out.println(num);
        num %= 3;
        System.out.println(num);
        num += (3 + 5);
        System.out.println(num);
    }

    public static void main(String[] args) {
        exam8();
    }
}

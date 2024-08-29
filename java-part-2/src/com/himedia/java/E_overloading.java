package com.himedia.java;

// * 오버로딩(overloading)
// 같은 이름의 메서드를 여러개 정의할 수 있게 해주는 자바의 기능이다.
// 단, 이 메서드들은 매개변수의 타입, 개수, 또는 순서가 달라야 한다.

// * 오버로딩의 규칙
// 1. 매개변수의 타입 : 매개변수의 데이터 타입이 다르면 오버로딩이 가능하다.
// 2. 매개변수의 개수 : 매개변수의 개수가 다르면 오버로딩이 가능하다.
// 3. 매개변수의 순서 : 매개변수의 타입이 다를 경우, 그 순서를 바꿔서 오버로딩할 수 있다.

// 주의 : 반환 타입이 다르다고 해서 오버로딩이 성립하는 것은 아니다.
// 즉 매개변수 목록이 동일하지만 반환 타입만 다른 메서드는 오버로딩으로 간주되지 않으며,
// 컴파일 오류가 발생한다.

// 오버로딩의 장점
// - 코드의 가독성 : 같은 이름의 메서드를 사용해 다양한 입력을 처리할 수 있어 코드가 직관적이다.
// - 유지보수 용이성 : 관련된 작업을 수행하는 메서드를 같은 이름으로 그룹화하여 코드를 유지 관리하기 쉽게 한다.
// - 다형성 : 컴파일 시점에서 적절한 메서드를 선택하는 컴파일타입 다형성을 제공한다.

// 오버로딩은 자바에서 메서드를 유연하고 효율적으로 사용하는 중요한 기법이다.
// 동일한 작업을 수행하되, 입력 형태에 따라 조금씩 다른 동작을 요구할 때 유용하게 사용된다.

public class E_overloading {
    // 두 정수의 합을 반환하는 메서드
    public int add(int a, int b) {
        return a + b;
    }

    // 세 정수의 합을 반환하는 메서드(매개변수 개수가 다름)
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // 여러 개의 정수를 더하는 메서드(가변인자 사용)
    public int add (int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // 두 실수의 합을 반환하는 메서드(매개변수 타입이 다름)
    public double add(double a, double b) {
        return a + b;
    }

    // 두 정수의 곱을 반환하는 메서드 (매개변수 타입이 다름)
    public int multiply(int a, int b) {
        return a * b;
    }

    // 두 실수의 곱을 반환하는 메서드 (매개변수 타입이 다름)
    public double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        E_overloading math = new E_overloading();

        System.out.println(math.add(1, 2));
        System.out.println(math.add(1, 2, 3));
        System.out.println(math.add(1, 2, 3, 4, 5, 6, 7));
    }
}

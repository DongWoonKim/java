package com.himedia.java;

// * JVM의 메모리 구조
// 1. 메서드 영역(method area)
// 프로그램 실행 중 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스파일을 읽어서 분석하여
// 클래스에 대한 정보를 이곳에 저장 한다.
// 이때, 그 클래스의 클래스변수도 이 영역에 함께 생성된다.

// 2. 힙(heap)
// 인스턴스가 생성된느 공간, 프로그램 실행 중 생성되는 인스턴스는 모두 이곳에 생성된다.

// 3. 호출스택(call stack)
// 호출스택은 메서드의 작업에 필요한 메모리 공간을 제공한다.
// 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되며,
// 이 메모리는 메서드가 작업을 수행하는 동안 지역변수(매개변수 포함)들과 연산의 중간결과 등을 저장하는데 사용된다.
// 그리고 메서드가 작업을 마치면 할당되었던 메모리 공간은 반환되어 비워진다.

// - 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
// - 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
// - 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.

// * 기본형 매개변수 : 변수의 값을 읽기만 할 수 있다.(read only)
// * 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있다.(read & write)
class Data {
    int x = 5;
}

public class C_jvm_memory {
    public static void main(String[] args) {
        C_jvm_memory jvm = new C_jvm_memory();
//        jvm.exam1();
        jvm.exam4();

    }

    public void exam1() {
        firstMethod();
    }

    public void firstMethod() {
        secondMethod();
    }

    public void secondMethod() {
        System.out.println("Second Method");
    }

    public void exam2() {
        Data d = new Data();
        int x = 5;
        System.out.println(d.x + " : " + x);
        changeDate(d, x);
        System.out.println(d.x + " : " + x);

    }

    public void changeDate(Data d, int x) {
        d.x = d.x + 1;
        x = x + 1;
    }

    public void exam3() {
        Data d1 = new Data();
        Data d2 = copy(d1);
        d1.x = 10;

        System.out.println("d1 : " + d1 + " : " + d1.x);
        System.out.println("d2 : " + d2 + " : " + d2.x);
    }

    public Data copy(Data d) {
        Data tmp = new Data();
        tmp.x = d.x;
        return tmp;
    }

    public void exam4() {
        // * 재귀호출(Recursive call)
        // 메서드의 내부에서 메서드 자신을 다시 호출하는 것을 '재귀호출'이라고 하고,
        // 재귀호출을 하는 메서드를 '재귀 메서드'라고 한다.
        int result = factorial(4);
        System.out.println(result);
    }

    public int factorial(int n) {
        // 기저조건
        if ( n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

}

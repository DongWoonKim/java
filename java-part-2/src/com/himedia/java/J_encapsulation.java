package com.himedia.java;

// * 캡슐화(Encapsulation)
// 객체 지향 프로그램이의 기본 원칙 중 하나로, 데이터를 숨기고 그 데이터를 조작하는 메서드만 외부에 노출하여
// 객체 내부의 상태를 보호하는 개념이다.
// 캡슐화의 핵심 목표는 외부에서 객체의 내부 구조를 직접적으로 접근하거나 수정하지 못하게 하고,
// 이를 통해 데이터의 무결성과 보안성을 유지하는 것이다.

// * 캡슐화의 주요 특징
// 1. 데이터 은닉
// 객체의 필드(변수)를 private 또는 protected로 설정하여 외부 클래스에서 직접 접근할 수 없도록 한다.
// 이렇게 하면 객체 내부의 상태가 무분별하게 변경되는 것을 막을 수 있다.
// 2. 접근 제어자
// 접근 제어자를 사용하여 클래스 멤버(필드와 메서드)에 대한 접근 권한을 제어한다.
// 이를 통해 어떤 클래스가 특정 멤버에 접근할 수 있는지를 정의한다.
// 3. Getter와 Setter
// 필드가 private으로 설정된 경우, 외부에서 이 필드에 접근하기 위해 getter와 setter메서드를 제공한다.
// 이 메서드를 통해 필드에 접근하거나 값을 변경할 수 있으며, 이때 유효성 검사를 추가할 수도 있다.

// * 캡슐화의 장점
// 1. 데이터 보호
// 외부에서 객체의 내부 데이터를 직접적으로 수정할 수 없기 때문에, 데이터의 무결성을 보호할 수 있다
// 2. 유연성
// 객체 내부의 구현을 변경하더라도 외부 인터페이스는 동일하게 유지될 수 있어
// 코드의 유연성과 확장성이 높아진다.
// 3. 유지보수성
// 코드가 잘 구조화되어 유지보수가 용이해진다.

public class J_encapsulation {
    // private 필드로 선언하여 외부에서 직접 접근할 수 없도록 함
    private String name;
    private int age;

    // Setter메서드 : 외부에서 필드에 값을 설정할 수 있도록 허용
    public void setName(String name) {
        this.name = name;
    }

    // 유효성을 검사를 추가하여 올바른 값만 설정되도록 함.
    public void setAge(int age) {
        if ( age > 0 ) {
            this.age = age;
        } else {
            System.out.println("잘 못된 입력입니다.");
        }
    }

    // Getter메서드 : 외부에서 필드에 접근할 수 있도록 허용
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

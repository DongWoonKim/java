package com.himedia.java;

// * 상속
// 하나의 클래스가 다른 클래스의 속성과 메서드를 물려받아 사용하는 것을 의미한다.
// 상속을 통해 코드 재사용성을 높이고, 계층 구조를 형성하며,
// 기존 클래스를 확장하여 새로운 클래스를 정의할 수 있다.

// * 주요특징
// 1. 부모 클래스(슈퍼클래스, superclass)
// 상속을 제공하는 클래스이다. 다른 클래스들이 상속받을 수 있는 일반적인 속성과 메서드를 정의한다.
// 2. 자식 클래스(서브클래스, subclass)
// 부모 클래스를 상속받아 확장하는 클래스이다. 부모 클래스의 모든 속성과 메서드를 물려받으며,
// 필요에 따라 추가적인 속서이나 메서드를 정의할 수 있다.
// 3. extends 키워드
// 자식 클래스가 부모 클래스를 상속받기 위해 사용된다.
// 4. 메서드 오버라이딩(Method Overriding)
// 자식 클래스가 부모 클래스의 메서드를 재정의하여 사용할 수 있다.
// 이때 부모 클래스의 메서드와 동일한 이름, 반환 타입, 매개변수를 가져야한다.
// 5. 다형성(Polymorphism)
// 상속을 통해 자식 클래스는 부모 클래스의 형태로 사용될 수 있으며, 이는 코드의 유연성과 확장성을 높인다.

// * 오버라이딩(Overriding)
// 자바에서 상속받은 부모 클래스의 메서드를 자식 클래스에서 재정의하여 사용하는 기법이다.
// 오버라이딩을 통해 자식 클래스는 부모 클래스의 기본 기능을 유지하면서도,
// 자신만의 방식으로 그 기능을 수정하거나 확장할 수 있다.

// * 주요 특징
// 1. 메서드 재정의
// 오버라이딩은 부모 클래스에서 정의된 메서드를 자식 클래스에서 동일한 이름, 반환 타입, 매개변수를 사용해
// 다시 정의하는 것이다.
// 2. 상속관계
// 오버라이딩은 상속 관계에 있는 클래스들 간에서만 가능하다.
// 자식 클래스가 부모 클래스의 메서드를 상속받아 이를 재정의할 때 오버라이딩이 발생한다.
// 3. 메서드 시그니처
// 오버라이딩하는 메서드는 부모 클래스에서의 메서드와 동일한 시그니처(이름, 매개변수, 반환타입)를 가져야한다.
// 4. @override 어노테이션
// 자바에서는 오버라이딩된 메서드위에 어노테이션을 붙여 명시적으로 오버라이딩임을 표시할 수 있다.
// 이 어노테이션을 사용하면 컴파일러가 오버라이딩이 올바르게 이루어졌는지 검증해준다.
// 5. 다형성
// 오버라이딩은 다형성의 기반이 된다. 부모 클래스 타입의 참조 변수가 자식 클래스의 객체를 참조할 때,
// 오버라이딩된 메서드가 호출되어 자식 클래스 메서드가 실행된다.
// 6. 단일 상속
// 자바는 '다중 상속'을 허용하지 않고, 단일 상속만 허용한다.

public class G_inheritance {
    public static void main(String[] args) {
        G_dog dog = new G_dog();
        dog.name = "baduk";
        dog.eat();
        dog.sleep();
        dog.bark();
        dog.walk();

        G_bird bird = new G_bird();
        bird.name = "sae";
        bird.wing = "light wing";
        bird.eat();
        bird.sleep();
        bird.fly();
        bird.walk();

    }
}

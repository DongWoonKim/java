package com.himedia.java;

class OuterClass {

    int instanceVar = 10;
    static int staticVar = 20;

    // 자바에서는 클래스 안에 다른 클래스를 정의할 수 있다.
    // 이때 중첩된 클래스가 static으로 선언되면, 해당 클래스는 정적 중첩 클래스가 된다.
    static class StaticNestedClass {    
        void display() {
            // 정적 중첩 클래스에서는 바깥 클래스의 static 변수에만 접근 가능
            System.out.println("Static variable : " + staticVar);

            // 바깥 클래스의 인스턴스 변수는 접근 불가
//            System.out.println("Instance variable : " + instanceVar);
        }
    }

    class InnerClass {
        void display() {
            System.out.println("Static variable : " + staticVar); // 정상 작동
            System.out.println("Inner variable : " + instanceVar); // 정상 작동
        }
    }

}

public class D_static_class {

    // - 클래스 소속
    // 정적 중첩 클래스는 바깥 클래스의 인스턴스와 독립적이다.
    // 즉 이 클래스는 바깥 클래스의 인스턴스에 속하지 않으며, 바깥 클래스의 인스턴스가 없이도 사용될 수 있다.
    // 비정적 중첩 클래스(Innter class)는 바깥 클래스의 인스턴스에 종속된다.
    // 즉 이 클래스는 바깥 클래스의 인스턴스와 연결되며, 바깥 클래스의 인스턴스 없이는 사용될 수 없다.

    // - 인스턴스화
    // -> 정적 중첩 클래스의 인스턴스를 생성할 때는 바깥 클래스의 인스턴스가 필요하지 않다.
    // 바깥 클래스의 이름만 사용하여 직접 인스턴스를 생성할 수 있다.
    // -> 비정적 중첩 클래스의 인스턴스를 생성하려면 먼저 바깥 클래스의 인스턴스를 생성해야 한다.
    // 중첩 클래스의 인스턴스를 생성할 때 바깥 클래스의 인스턴스를 명시적으로 참조해야 한다.

    // - 메모리 관리와 성능
    // [정적 중첩 클래스]
    // 바깥 클래스의 인스턴스와 독립적으로 존재하므로, 메모리 사용이 더 효율적일 수 있다.
    // 특히 중첩 클래스가 바깥 클래스의 인스턴스 데이터에 접근할 필요가 없는 경우,
    // 정적 중첩 클래스를 사용하는 것이 더 적합하다.

    // [비정적 중첩 클래스]
    // 바깥 클래스의 인스턴스와 연결되기 때문에, 인스턴스당 추가적인 메모리를 소비할 수 있다.
    // 따라서 이 클래스가 바깥 클래스의 인스턴스 데이터에 접근해야 하는 경우에만 사용하는 것이 좋다.

    // - 결론
    // [정적 중첩 클래스]
    // 바깥 클래스의 인스턴스와 독립적으로 사용할 수 있고, 주로 바깥 클래스의 정적 멤버만 필요할 때 사용됩니다.
    // [비정적 중첩 클래스]
    // 바깥 클래스의 인스턴스와 밀접하게 연결되어 있으며, 바깥 클래스의 인스턴스 멤버에 접근해야 할 때 사용됩니다.
    public static void main(String[] args) {
        // Static Nested Class의 인스턴스를 생성하기 위해서는 바깥 클래스의 인스턴스가 필요하지 않음.
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        staticNestedClass.display();

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerObj = outerClass.new InnerClass();
        innerObj.display();
    }
}

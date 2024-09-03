package himedia.java;

// * 제네릭(Generic)
// 자바에서 클래스, 인터페이스, 메서드를 정의할 때 사용할 데이터 타입을 지정하지 않고,
// 필요할 때 사용할 데이터 타입을 지정할 수 있게 하는 기능이다.
// 제네릭을 사용하면 컴파일 시 타입 안정성을 보장하고, 불필요한 타입 캐스팅을 줄일 수 있다.

// * 제네릭의 주요 특징
// 1. 타입 안정성 : 컴파일 시점에서 잘못된 타입 사용을 방지하여 런타임 에러를 줄일 수 있다.
// 2. 재사용성 : 동일한 코드가 다양한 데이터 타입에서 동작할 수 있도록 한다.
// 3. 캐스팅 제거 : 불필요한 타입 캐스팅을 줄인다.

public class B_generic<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        B_generic<Integer> intBox = new B_generic<>();
        intBox.setItem(1234);
        System.out.println("Integer value : " + intBox.getItem());

        B_generic<String> strBox = new B_generic<>();
        strBox.setItem("Hello");
        System.out.println("String value : " + strBox.getItem());
    }
}

package himedia.java;

// * enum(열거형)
// 자바에서 특정한 상수 집합을 정의하는데 사용되는 특별한 데이터 타입이다.
// 예를들어 요일, 색상, 방향 등과 같은 고정된 개수의 상스들을 나타낼 때 유용하다.
// enum은 클래스처럼 보이지만 실제로는 고정된 상수들의 집합을 정의하는 것이며,
// 모든 enum은 java.lang.Enum 클래스를 상속받는다.

// * enum 사용의 장점
// - 코드의 명확성 : 코드에서 상수 값을 직접 사용하지 않고 enum을 사용하여 의미를 명확하게 전달할 수 있다.
// - 타입 안정성 : 잘못된 값이 사용되는 것을 방지한다.
// - 유지보수 용이성 : 새로운 상수를 추가하거나 기존 상수를 변경할 때 코드 전체를 쉽게 수정할 수 있다.

public class B_enum {

    public static void exam1() {
        B_day today = B_day.TUESDAY;
        System.out.println(B_day.TUESDAY.ordinal());
        System.out.println(B_day.TUESDAY.name());
        switch (today) {
            case MONDAY:
                System.out.println("Today is MONDAY");
                break;
            case TUESDAY:
                System.out.println("Today is TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Today is WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Today is THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Today is FRIDAY");
                break;
            case SATURDAY:
                System.out.println("Today is SATURDAY");
                break;
            case SUNDAY:
                System.out.println("Today is SUNDAY");
                break;
        }
    }
    
    public static void exam2() {
        // 모든 값을 순회
        for ( B_day_2 day : B_day_2.values()) {
            System.out.println(day.ordinal() + " : " + day.name() + " : " + day.getDescription());
        }
    }

    public static void main(String[] args) {
        exam2();
    }

}

package himedia.java;

// * list
// 순서가 있는 요소들의 컬렉션을 나타내는 인터페이스이다.
// List 인터페이스를 구현하는 대표적인 클래스에는 ArrayList, LinkedList, Vector 등이 있다.
// List는 중복된 요소를 허용, 인덱스를 기반으로 요소에 접근한다.

// * 주요 특징
// - 순서 유지 : List는 요소들이 추가된 순서를 유지된다.
// - 인덱스로 접근 : 각 요소는 인덱스를 통해 접근할 수 있다. 인덱스는 0부터 시작한다.
// - 중복 허용 : 동일한 값을 가진 요소가 여러 개 있을 수 있다.
// - 유연한 크기 : 구현체는 동적으로 크기를 조절할 수 있다.

// * 주요 메서드
// - add(E e) : 리스트에 요소를 추가한다.
// - get(int index) : 인덱스에 해당하는 요소를 반환한다.
// - remove(int index) : 인덱스에 해당하는 요소를 제거한다.
// - size() : 리스트의 요소 개수를 반환한다.
// - contains(Object o) : 리스트에 특정 요소가 포함되어 있는지 확인한다.
// - clear() : 리스트의 모든 요소를 제거한다.

// * 요약
// - ArrayList는 배열 기반의 리스트로, 인덱스를 통한 빠른 접근이 가능하지만,
// 중간 삽입/삭제가 느리다.
// - LinkedList는 노드 기반의 리스트로, 삽입/삭제가 빠르지만 인덱스를 통한 접근이 느리다.
// - Stack은 후입선출(Last In First Out) 구조를 가지며, 요소를 스택에 추가하고 제거하는데 사용된다.

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class A_collections_list {

    // 1. ArrayList
    public static void exam1() {
        List<String> list = new ArrayList<>();

        // 요소 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // 특정 인덱스에 요소 추가
        list.add(1, "Grape");

        // 리스트 크기 확인
        System.out.println("List size : " + list.size());

        // 인덱스를 사용하여 요소 접근
        System.out.println("Element at index 2 : " + list.get(2));

        // 요소 제거
        list.remove(3);

        // 리스트의 모든 요소 출력
        System.out.println("List elements : " + list);

        // 특정 요소가 리스트에 포함되어 있는지 확인
        if (list.contains("Apple")) {
            System.out.println("Apple found");
        }

        // 리스트의 모든 요소 제거
//        list.clear();
//        System.out.println("List after clear : " + list);

        // 순회 방법 1 : for 루프 사용
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }

        // 순회 방법 2 : for 루프2 사용
        for ( String s : list ) {
            System.out.println(s);
        }
        
        // 순회 방법 3 : Iterator 사용
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Iterator : " + element);
        }
        
        // 역방향 순회
        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.println("Iterator reversed : " + element);
        }

    }

    // 2. LinkedList

    public static void main(String[] args) {
        exam1();
    }

}

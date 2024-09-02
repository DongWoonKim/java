package himedia.java;

// * Set
// 중복되지 않는 요소들의 집합을 나타낸다.
// Set 인터페이스를 구현하는 대표적인 클래스에는 HahsSet, TreeSet, LinkedHashSet 등이 있다.
// Set은 요소의 순서를 보장하지 않으며, 각 요소는 고유하다.

// * 주요 특징
// - 중복 허용 안함 : Set은 동일한 요소가 두 번 이상 포함될 수 없다.
// - 순서 보장 안됨 : 일반적으로 요소의 삽입 순서를 보장하지 않지만, 일부 구현체(LinkedHashSet)는 순서를 유지할 수 있다.
// - 빠른 검색 : Set은 특정 요소가 존재하는지 빠르게 검색할 수 있다.

// * 주요 메서드
// - add(E e) : 집합에 요소를 추가한다. 중복된 요소가 추가되면 추가되지 않는다.
// - remove(Object o) : 특저 요소를 제거한다.
// - contains(Object o) : 집합에 특정 요소가 포함되어 있는지 확인한다.
// - size() : 집합의 요소 개수를 반환한다.
// - clear() : 집합의 모든 요소를 제거한다.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A_collections_set {

    // 1. HashSet
    // - 해시 기반 : HashSet은 내부적으로 HashMap을 사용하여 요소를 저장한다.
    // - 빠른 성능 : 요소의 추가, 삭제, 검색 속도가 빠르다. 시간복잡도 : O(1)
    // - 순서 없음 : 요소의 순서를 보장하지 않는다.
    public static void exam1() {
        Set<String> hashSet = new HashSet<String>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        System.out.println("HashSet 1 : " + hashSet);
        hashSet.add("Apple");
        System.out.println("HashSet 2 : " + hashSet);

        hashSet.remove("Banana");
        System.out.println("After remove : " + hashSet);

        boolean result = hashSet.contains("Apple");
        System.out.println("Does set contain apple ? " + result);

        // 순회 방법 1 : for
        for ( String element : hashSet ) {
            System.out.println("Element : " + element);
        }

        //순회 방법 2 : Iterator
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Element : " + element);
        }
    }

    // 2. TreeSet
    // - 이진 검색 트리 기반 : TreeSet은 내부적으로 TreeMap을 사용하여 요소를 저장한다.
    // - 정렬된 순서 : 요소가 자동으로 오름차순으로 정렬된다.
    public static void exam2() {
        Set<String> treeSet = new HashSet<String>();

        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");
        System.out.println("TreeSet 1 : " + treeSet);
        treeSet.add("Apple");
        System.out.println("TreeSet 2 : " + treeSet);

        treeSet.remove("Banana");
        System.out.println("After remove : " + treeSet);

        boolean result = treeSet.contains("Apple");
        System.out.println("Does set contain apple ? " + result);

        // 순회 방법 1 : for
        for ( String element : treeSet ) {
            System.out.println("Element : " + element);
        }

        //순회 방법 2 : Iterator
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Element : " + element);
        }
    }

    public static void main(String[] args) {
        exam1();
    }
}

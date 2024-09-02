package himedia.java;

// * Map
// 키와 값의 쌍을 저장하는 자료구조를 나타낸다.
// Map은 중복된 키를 허용하지 않으며, 각 키는 하나의 값에 매핑된다.
// Map인터페이스를 구현하는 대표적인 클래스에는 HashMap, TreeMap, LinkedHashMap 등이 있다.

// * 주요 특징
// - 키-값 쌍 : Map은 각 요소를 키와 값의 쌍으로 저장한다.
// - 중복된 키 허용 안함 : 동일한 키를 두 번 추가할 수 없다.
// 만약 동일한 키를 다시 추가하면 기존의 값이 덮어씌워진다.
// - 빠른 검색 : 특정 키를 사용하여 값에 빠르게 접근할 수 있다.

// * 주요 메서드
// - put(K kye, V value) : 맵에 키와 값을 추가한다.
// 만약 동일한 키가 이미 존재한다면 해당 키의 값이 새 값으로 대체된다.
// - get(Object key) : 키에 대응하는 값을 반환한다. 해당 키가 존재하지 않으면 null을 반환한다.
// - remove(Object key) : 특정 키에 대응하는 키-값 쌍을 제거한다.
// - containsKey(Object key) : 맵에 특정 키가 포함되어 있는지 확인한다.
// - containsValue(Object value) : 맵에 특정 값이 포함되어 있는지 확인한다.
// - size() : 맵에 저장된 키-값 쌍의 수를 반환한다.
// - clear() : 맵의 모든 요소를 제거한다.

// * 요약
// - HashMap은 빠른 검색과 삽입 성능을 제공하며, 요소의 순서를 보장하지 않는다.
// - TreeMap은 키를 기준으로 정렬된 순서를 유지하며, 레드-블래 트리 구조로 구성되어 있다.

// ** 레드-블랙 트리(Red-Black Tree)는 이진 검색 트리(Binary Search Tree)의 일종으로,
// 삽입, 삭제 등의 연산 후에도 트리의 균형을 유지하도록 설계된
// 자가 균형 이진 트리(Self-balancing Binary Search Tree)이다.

import java.util.HashMap;
import java.util.Map;

public class A_collections_map {

    // 1. HashMap
    public static void exam1() {
        Map<String, Integer> map = new HashMap<>();

        // 요소 추가
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Orange", 300);

        System.out.println("Map : " + map);

        // 특정 키에 대응하는 값 얻기
        Integer bValue = map.get("Banana");
        System.out.println("Value : " + bValue);

        // 요소 제거
        map.remove("Orange");
        System.out.println("Map : " + map);

        // 키 존재 여부 확인
        boolean aResult = map.containsKey("Apple");
        System.out.println("Value : " + aResult);

        // 순회 방법 1 : entrySet()
        for ( Map.Entry<String, Integer> entry : map.entrySet() ) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }

        // 순회 방법 2 : keySet()
        for( String key : map.keySet() ) {
            System.out.println("Key : " + key + ", Value : " + map.get(key));
        }

        // 순회 방법 3 : values()
        for ( Integer value : map.values() ) {
            System.out.println("Value : " + value);
        }

    }

    public static void main(String[] args) {
        exam1();
    }
}

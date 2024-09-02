package himedia.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_reviewImpl implements A_review {
    // 사용자ID - 내용
    private Map<String, String> contentMap;
    // 사용자ID - 좋아요
    private Map<String, Integer> likeMap;

    public A_reviewImpl() {
        this.contentMap = new HashMap<>();
        this.likeMap = new HashMap<>();
    }


    @Override
    public int printMenu() {
        System.out.println("==================== 리뷰 프로그램 ====================");
        System.out.println("[1]리뷰 추가 [2]좋아요 [3]전체 보기 [4]리뷰 삭제 [5]종료");
        System.out.println("=====================================================");

        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 번호를 입력하세요.");

        return sc.nextInt();
    }

    @Override
    public void addReview() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID를 입력해주세요.");
        String userId = sc.nextLine().trim();
        System.out.println("내용을 입력해주세요.");
        String content = sc.nextLine().trim();

        if ( !checkString(userId) || !checkString(content) ) {
            System.out.println("ID 혹은 내용이 비었습니다. 다시 입력 해주세요.");
            return;
        }

        insertDatabase(userId, content, 0);
    }

    @Override
    public void insertDatabase(String id, String content, int likeCnt) {
        contentMap.put(id, content);
        likeMap.put(id, likeCnt);
    }

    @Override
    public void selectAll() {
        for ( String key : contentMap.keySet() ) {
            System.out.println(key + ":" + contentMap.get(key) + "\t" + likeMap.get(key));
        }
    }

    @Override
    public void upLike() {
        selectAll();
        Scanner sc = new Scanner(System.in);
        System.out.println("Id를 입력하세요.");
        String userId = sc.nextLine().trim();

        if( !checkString(userId) ) {
            System.out.println("Id를 입력하지 않았습니다.");
            return;
        }

        if (likeMap.containsKey(userId)) {
            likeMap.put(userId, likeMap.get(userId) + 1);
        } else {
            System.out.println("ID를 잘 못 입력하였습니다.");
        }
    }

    @Override
    public void deleteContent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Id를 입력하세요.");
        String userId = sc.nextLine().trim();

        if( !checkString(userId) ) {
            System.out.println("Id를 입력하지 않았습니다.");
            return;
        }

        if (contentMap.containsKey(userId)) {
            contentMap.remove(userId);
            likeMap.remove(userId);
        } else {
            System.out.println("찾으시는 ID가 없습니다.");
        }
    }

    private boolean checkString(String str) {
        return str.length() == 0 ? false : true;
    }
}

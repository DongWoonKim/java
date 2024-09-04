package himedia.java.review;
/*
A_review.java(I) -> 인터페이스
A_reviewImpl.java -> 구현체
A_start.java -> 시작점
// 시작점을 제외한main static 금지
// 단, 상수로서 사용 시에는 가능.

[1] 댓글 추가
-> 사용자ID, 내용을 입력받는다.  -> 사용자ID, 내용이 비어 있으면 등록시키지 않는다. ~trim()(공백문자열 제거)
-> 이미 사용자ID가 있으면 그냥 덮어씌운다.
+ 좋아요 갯수도 0개로 초기화
[2] 좋아요
-> 리스트가 출력
사용자 ID : 내용1~~
사용자 ID : 내용2~~
사용자 ID : 내용3~~
사용자 ID : 내용4~~
사용자ID를 입력 -> 좋아요 +1
[3] 전체 보기
사용자 ID 별 좋아요 갯수를 출력
사용자 ID : 3 : 내용
[4] 내용삭제
[5] 종료
 */
public class A_start {

     public static void main(String[] args) {

        A_review review = new A_reviewImpl();

        while (true) {
            int choice = review.printMenu();
            switch (choice) {
                case 1:
                    review.addReview();
                    break;
                case 2:
                    review.upLike();
                    break;
                case 3:
                    review.selectAll();
                    break;
                case 4:
                    review.deleteContent();
                    break;
                case 5:
                    System.out.println("이용해 주셔서 감사합니다.");
                    return;
            }
        }
        
    }
}

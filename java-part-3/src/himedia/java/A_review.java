package himedia.java;

public interface A_review {
    int printMenu();
    void addReview();
    void insertDatabase(String id, String content, int likeCnt);
    void selectAll();
    void upLike();
    void deleteContent();
}

package himedia.java;

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

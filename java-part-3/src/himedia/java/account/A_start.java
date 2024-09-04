package himedia.java.account;
/*
    A_account.java(I)
    A_accountImpl.java
    -> History저장소 collections로 바꿀것.
    -> Histories는 계속 저장될 수 있다.
    A_start3.java

    -> 상수로서 사용 목적이 아니라면 static 사용금지
 */
public class A_start {
    public static void main(String[] args) {
        A_account account = new A_accountImpl();
        account.printCreateAccountMenu();

        while (true) {
            int choice = account.printMenu();
            switch (choice) {
                case 1:
                    account.addMoney();
                    break;
                case 2:
                    account.subMoney();
                    break;
                case 3:
                    account.printHistory();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
            }
        }

    }
}

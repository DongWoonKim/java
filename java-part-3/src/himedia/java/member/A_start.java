package himedia.java.member;

public class A_start {
    public static void main(String[] args) {
        A_member manager = new A_managementImpl();
        manager.printPricePlan();

        while(true) {
            int menuNum = manager.printMenu();
            switch (menuNum) {
                case 1:
                    manager.addMember();
                    break;
                case 2:
                    manager.selectEmail();
                    break;
                case 3:
                    manager.selectName();
                    break;
                case 4:
                    manager.selectAll();
                    break;
                case 5:
                    manager.updateMember();
                    break;
                case 6:
                    manager.deleteMember();
                    break;
                case 7:
                    manager.printPricePlan();
                    break;
                case 8:
                    manager.initMember();
                    break;
                case 9:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 선택하셨습니다.");
                    break;
            }
        }
    }
}

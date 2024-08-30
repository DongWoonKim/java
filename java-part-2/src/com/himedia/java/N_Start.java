package com.himedia.java;

public class N_Start {

    static final int COKE = 500, CIDER = 700, FANTA = 300, WATER = 200;

    public static void main(String[] args) {

        N_vending vendingMachine = new N_Machine();

        while (true) {
            vendingMachine.printMenu();
            int myChoice = vendingMachine.getChoice();
            int result = -1;
            switch (myChoice) {
                case 1:
                    result = vendingMachine.calcMoney(COKE);
                    if ( result < 0 ) {
                        vendingMachine.printException();
                    } else {
                        vendingMachine.setTotalMoney(result);
                        System.out.println("콜라가 나왔습니다.");
                    }
                    break;
                case 2:
                    result = vendingMachine.calcMoney(CIDER);
                    if ( result < 0 ) {
                        vendingMachine.printException();
                    } else {
                        vendingMachine.setTotalMoney(result);
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;
                case 3:
                    result = vendingMachine.calcMoney(FANTA);
                    if ( result < 0 ) {
                        vendingMachine.printException();
                    } else {
                        vendingMachine.setTotalMoney(result);
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;
                case 4:
                    result = vendingMachine.calcMoney(WATER);
                    if ( result < 0 ) {
                        vendingMachine.printException();
                    } else {
                        vendingMachine.setTotalMoney(result);
                        System.out.println("물이 나왔습니다.");
                    }
                    break;
                case 5:
                    // getMoney
                    int orgMoney = vendingMachine.getTotalMoney();
                    int getMoney = vendingMachine.getMoney();
                    vendingMachine.setTotalMoney(orgMoney + getMoney);
                    break;
                case 6:
                    System.out.printf("잔돈 : %d원이 반환되었습니다.", vendingMachine.getTotalMoney());
                    return;
                default:
                    System.out.println("잘 못 누르셨습니다.");
            }
        }
    }
}

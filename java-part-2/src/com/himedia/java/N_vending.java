package com.himedia.java;

public interface N_vending {
    void printMenu();
    int getChoice();
    int getMoney();
    int calcMoney(int price);
    void printException();
    void setTotalMoney(int totalMoney);
    int getTotalMoney();
}

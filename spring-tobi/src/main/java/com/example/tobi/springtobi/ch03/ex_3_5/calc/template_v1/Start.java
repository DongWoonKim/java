package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v1;

import java.io.File;
import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        Start start = new Start();
        start.sumOfNumbers();
    }

    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();

        String userHome = System.getProperty("user.home");
        String desktop = userHome + File.separator + "Desktop";
        String filepath = desktop + File.separator + "java" + File.separator + "numbers.txt";

        int sum = calculator.calcSum(filepath);

        System.out.println(sum);
    }

}

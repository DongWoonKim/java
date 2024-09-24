package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        Integer sum = 0;
        String line;

        while ( (line = br.readLine()) != null ) {
            sum += Integer.parseInt(line);
        }

        br.close();
        return sum;
    }
}

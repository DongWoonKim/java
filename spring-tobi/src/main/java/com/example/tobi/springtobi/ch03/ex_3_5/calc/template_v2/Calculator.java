package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer sum = 0;
            String line;

            while ( (line = br.readLine()) != null ) {
                sum += Integer.parseInt(line);
            }

            return sum;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer multiply = 1;
            String line;

            while ( (line = br.readLine()) != null ) {
                multiply *= Integer.parseInt(line);
            }
            return multiply;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }
}

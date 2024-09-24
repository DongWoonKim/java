package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        LineCallBack callback = new LineCallBack() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.parseInt(line);
            }
        };

        return lineReadTemplate(filepath, callback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
         LineCallBack callback = new LineCallBack() {
             @Override
             public Integer doSomethingWithLine(String line, Integer value) {
                 return value * Integer.parseInt(line);
             }
         };

        return lineReadTemplate(filepath, callback, 1);
    }

    public Integer lineReadTemplate(String filepath, LineCallBack callback, int initValue) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer result = initValue;
            String line;

            while ((line = br.readLine()) != null) {
                result = callback.doSomethingWithLine(line, result);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

}

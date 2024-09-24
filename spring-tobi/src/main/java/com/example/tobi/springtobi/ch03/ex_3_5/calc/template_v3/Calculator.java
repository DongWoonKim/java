package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader reader) throws IOException {
                Integer sum = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    sum += Integer.valueOf(line);
                }

                return sum;
            }
        };

        return fileReadTemplate(filepath, callback);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader reader) throws IOException {
                Integer multiply = 1;
                String line;

                while ((line = reader.readLine()) != null) {
                    multiply *= Integer.valueOf(line);
                }

                return multiply;
            }
        };

        return fileReadTemplate(filepath, callback);
    }

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int result = callback.doSomethingWithReader(br);
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

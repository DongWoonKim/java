package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v3;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader reader) throws IOException;
}

package org.example.textanalyzer;

import java.io.*;
import java.util.*;


public class Main {
    private static final String PATH = "text.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(PATH));
        Queue<Character> symbols = GetQueueOfSymbol.getQueue(reader);
        ApplyAnalysis.applyAnalysis(symbols);
    }
}

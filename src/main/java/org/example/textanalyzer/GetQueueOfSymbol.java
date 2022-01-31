package org.example.textanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class GetQueueOfSymbol {

    public static Queue<Character> getQueue(BufferedReader reader) throws IOException {
        Queue<Character> symbols = new ArrayDeque<>();
        String line = reader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                symbols.add(symbol);
            }
            line = reader.readLine();
        }
        return symbols;
    }
}

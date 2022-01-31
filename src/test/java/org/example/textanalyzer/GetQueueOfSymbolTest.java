package org.example.textanalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class GetQueueOfSymbolTest {

    @Test
    void getQueue() throws IOException {
        int expected = 76;
        int actual = GetQueueOfSymbol.getQueue(new BufferedReader(new FileReader("text.txt"))).size();

        assertEquals(actual, expected);
    }
}
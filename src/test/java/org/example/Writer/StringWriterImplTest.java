package org.example.Writer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringWriterImplTest {

    @Test
    void writeChar() {
        String string = "flex = chill + rofl";
        StringBuilder stringBuilder = new StringBuilder();
        StringWriterImpl stringWriter = new StringWriterImpl(stringBuilder);
        for (char symbol: string.toCharArray()) {
            stringWriter.writeChar(String.valueOf(symbol));
        }
        assertEquals(string, stringBuilder.toString());
    }
}
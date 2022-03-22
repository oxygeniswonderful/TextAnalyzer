package org.example.Writer;

import org.example.io.Writer.StringWriterImpl;
import org.example.io.Writer.WriterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringWriterImplTest {

    @Test
    void writeChar() throws WriterException {
        String string = "flex = chill + rofl";
        StringBuilder stringBuilder = new StringBuilder();
        StringWriterImpl stringWriter = new StringWriterImpl(stringBuilder);
        for (char symbol: string.toCharArray()) {
            stringWriter.writeChar(String.valueOf(symbol));
        }
        assertEquals(string, stringBuilder.toString());
    }
}
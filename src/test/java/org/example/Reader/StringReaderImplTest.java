package org.example.Reader;

import org.example.io.Reader.ReaderException;
import org.example.io.Reader.StringReaderImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReaderImplTest {

    @Test
    void hasChars() throws ReaderException {
        String string1 = "flex = chill + rofl";
        String string2 = "";
        boolean actual1 = true;
        boolean actual2 = false;
        StringReaderImpl stringReader1 = new StringReaderImpl(string1);
        StringReaderImpl stringReader2 = new StringReaderImpl(string2);
        boolean expected1 = stringReader1.hasChars();
        boolean expected2 = stringReader2.hasChars();
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);

    }

    @Test
    void readChars() throws ReaderException {
        String string1 = "flex = chill + rofl";
        StringReaderImpl stringReader1 = new StringReaderImpl(string1);
        for (char symbol: string1.toCharArray()) {
            assertEquals(symbol, stringReader1.readChars());
        }
    }
}
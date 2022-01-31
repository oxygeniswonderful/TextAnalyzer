package org.example.textanalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToolsTest {

    private Tools tools;

    @BeforeEach
    void setUp() {
        tools = new Tools();
    }

    @Test
    void createIndent() {
        String expected = "    ";
        String actual = tools.createIndent(4);
        assertEquals(actual, expected);
    }

    @Test
    void isLeftBrace() {
        boolean expected = true;
        boolean actual = tools.isLeftBrace('{');
        assertEquals(actual, expected);
    }

    @Test
    void isRightBrace() {
        boolean expected = true;
        boolean actual = tools.isRightBrace('}');
        assertEquals(actual, true);
    }

    @Test
    void isSemicolon() {
        boolean expected = true;
        boolean actual = tools.isSemicolon(';');
        assertEquals(actual, expected);
    }

    @Test
    void isOrdinarySymbol() {
        boolean expected = false;
        boolean actual = tools.isOrdinarySymbol('a');
        assertEquals(actual, expected);
    }
}
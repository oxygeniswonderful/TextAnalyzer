import org.example.Tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToolsTest {

    @org.junit.jupiter.api.Test
    void createIndent() {
        String actual, expected = "    ";
        actual = Tools.createIndent(4);
        assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void isLeftBrace() {
        boolean actual1, expected1 = true;
        boolean actual2, expected2 = false;
        actual1 = Tools.isLeftBrace("{");
        actual2 = Tools.isLeftBrace("}");
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }

    @org.junit.jupiter.api.Test
    void isRightBrace() {
        boolean actual1, expected1 = true;
        boolean actual2, expected2 = false;
        actual1 = Tools.isRightBrace("}");
        actual2 = Tools.isRightBrace("{");
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }

    @org.junit.jupiter.api.Test
    void isSemicolon() {
        boolean actual1, expected1 = true;
        boolean actual2,expected2 = false;
        actual1 = Tools.isSemicolon(";");
        actual2 = Tools.isSemicolon(":");
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }

    @org.junit.jupiter.api.Test
    void isOrdinarySymbol() {
        boolean actual1, expected1 = false;
        boolean actual2, expected2 = true;
        actual1 = Tools.isOrdinarySymbol("a");
        actual2 = Tools.isOrdinarySymbol("{");
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }
}

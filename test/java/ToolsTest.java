import org.junit.jupiter.api.Assertions;

class ToolsTest {

    @org.junit.jupiter.api.Test
    void createIndent() {
        String actual, expected = "    ";
        Tools tools = new Tools();
        actual = tools.createIndent(4);
        Assertions.assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void isLeftBrace() {
        boolean actual, expected = true;
        Tools tools = new Tools();
        actual = tools.isLeftBrace("{");
        Assertions.assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void isRightBrace() {
        boolean actual, expected = true;
        Tools tools = new Tools();
        actual = tools.isRightBrace("}");
        Assertions.assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void isSemicolon() {
        boolean actual, expected = true;
        Tools tools = new Tools();
        actual = tools.isSemicolon(";");
        Assertions.assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void isOrdinarySymbol() {
        boolean actual, expected = false;
        Tools tools = new Tools();
        actual = tools.isOrdinarySymbol("a");
        Assertions.assertEquals(actual, expected);
    }
}
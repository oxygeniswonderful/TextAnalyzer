public class Tools {
    String createIndent(int count) {
        String indent = "";
        for (int i = 0; i < count; i++)
            indent += " ";
        return indent;
    }

    boolean isLeftBrace(String symbol) {
        return symbol.equals("{");
    }
    boolean isRightBrace(String symbol) {
        return symbol.equals("}");
    }
    boolean isSemicolon(String symbol) {
        return symbol.equals(";");
    }
    boolean isOrdinarySymbol(String symbol) {
        Tools tools = new Tools();
        return (tools.isLeftBrace(symbol) | tools.isRightBrace(symbol) | tools.isSemicolon(symbol));
    }
}

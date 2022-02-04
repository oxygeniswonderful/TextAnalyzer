package org.example;

public class Tools {
    public static String createIndent(int count) {
        String indent = "";
        for (int i = 0; i < count; i++)
            indent += " ";
        return indent;
    }

    public static boolean isLeftBrace(Character symbol) {
        return symbol.equals('{');
    }
    public static boolean isRightBrace(Character symbol) {
        return symbol.equals('}');
    }
    public static boolean isSemicolon(Character symbol) {
        return symbol.equals(';');
    }
    public static boolean isOrdinarySymbol(Character symbol) {
        Tools tools = new Tools();
        return (tools.isLeftBrace(symbol) | tools.isRightBrace(symbol) | tools.isSemicolon(symbol));
    }
}

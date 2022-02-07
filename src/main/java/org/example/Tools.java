package org.example;

public class Tools {
    public static String createIndent(int count) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < count; i++)
            indent.append(" ");
        return indent.toString();
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
        return (Tools.isLeftBrace(symbol) | Tools.isRightBrace(symbol) | Tools.isSemicolon(symbol));
    }
}

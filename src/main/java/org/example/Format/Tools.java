package org.example.Format;

public class Tools {
    public static String createIndent(int count) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < count; i++)
            indent.append(" ");
        return indent.toString();
    }

    public static boolean isLeftBrace(String symbol) {
        return symbol.equals("{");
    }
    public static boolean isRightBrace(String symbol) {
        return symbol.equals("}");
    }
    public static boolean isSemicolon(String symbol) {
        return symbol.equals(";");
    }
    public static boolean isShift(String symbol) {
        return symbol.equals("\n");
    }
    }
    public static boolean isOrdinarySymbol(String symbol) {
        return (Tools.isLeftBrace(symbol) | Tools.isRightBrace(symbol) | Tools.isSemicolon(symbol) | Tools.isShift(symbol));
    }
}

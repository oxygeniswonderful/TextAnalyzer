package org.example.textanalyzer;

public class Tools {
    static String createIndent(int count) {
        return " ".repeat(Math.max(0, count));
    }

    static boolean isLeftBrace(Character symbol) {
        return symbol.equals('{');
    }

    static boolean isRightBrace(Character symbol) {
        return symbol.equals('}');
    }

    static boolean isSemicolon(Character symbol) {
        return symbol.equals(';');
    }

    static boolean isOrdinarySymbol(Character symbol) {
        return (isLeftBrace(symbol) | isRightBrace(symbol) | isSemicolon(symbol));
    }
}

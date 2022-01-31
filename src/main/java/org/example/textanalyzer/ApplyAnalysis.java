package org.example.textanalyzer;

import java.util.Queue;

public class ApplyAnalysis {

    public static void applyAnalysis(Queue<Character> symbols) {
        String indent = "";
        int count = 0;

        Character symbol;
        Character latestElement = ' ';

        while (!symbols.isEmpty()) {
            symbol = symbols.poll();
            
            if (Tools.isOrdinarySymbol(latestElement) & symbol.equals(' ')) {
                continue;
            }
            
            if (Tools.isSemicolon(latestElement) & !Tools.isRightBrace(symbol)) {
                System.out.print(indent);
            }

            if(Tools.isRightBrace(latestElement) & !Tools.isOrdinarySymbol(symbol)) {
                System.out.print(indent);
            }

            if (!Tools.isOrdinarySymbol(symbol)) {
                System.out.print(symbol);
            }

            if (Tools.isLeftBrace(symbol)) {
                count += 4;
                indent = Tools.createIndent(count);
                System.out.println(symbol);
                System.out.print(indent);
            }
            if (Tools.isRightBrace(symbol)) {
                count -= 4;
                indent = Tools.createIndent(count);
                System.out.print(indent);
                System.out.println(symbol);
            }
            if (Tools.isSemicolon(symbol))
                System.out.println(symbol);
            
            latestElement = symbol;
        }
    }
}

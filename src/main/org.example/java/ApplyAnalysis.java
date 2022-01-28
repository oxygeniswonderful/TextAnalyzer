import java.util.Queue;

public class ApplyAnalysis {
    public static void applyAnalysis(Queue<String> symbols) {
        Tools tools;
        String symbol, indent = "", latestElement = "";
        int count = 0;
        tools = new Tools();

        while (!symbols.isEmpty()) {
            symbol = symbols.poll();
            if (tools.isOrdinarySymbol(latestElement) & symbol.equals(" "))
                continue;
            if (!tools.isOrdinarySymbol(symbol)) {
                System.out.print(symbol);
            }
            if (tools.isLeftBrace(symbol)) {
                count += 4;
                indent = tools.createIndent(count);
                System.out.print(symbol);
                System.out.print("\n");
                System.out.print(indent);
            }
            if (tools.isRightBrace(symbol)) {
                count -= 4;
                indent = tools.createIndent(count);
                System.out.print(symbol);
                System.out.print("\n");
                System.out.print(indent);
            }
            if (tools.isSemicolon(symbol)) {
                System.out.print(symbol);
                System.out.print("\n");
                System.out.print(indent);
            }
            latestElement = symbol;
        }
    }
}

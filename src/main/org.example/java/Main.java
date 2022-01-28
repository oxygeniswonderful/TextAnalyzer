import java.io.*;
import java.util.*;


public class Main {
    private static final String PATH = "/text.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        Queue<String> symbols;
        reader = new BufferedReader(new FileReader(PATH));
        symbols = GetQueueOfSymbol.getQueue(reader);
        ApplyAnalysis.applyAnalysis(symbols);
    }
}

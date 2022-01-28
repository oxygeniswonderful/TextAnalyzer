import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class GetQueueOfSymbol {
    public static Queue<String> getQueue(BufferedReader reader) throws IOException {
        Queue<String> symbols = new ArrayDeque<>();
        String line = reader.readLine();
        while (line != null) {
            for (char s: line.toCharArray()) {
                symbols.add(String.valueOf(s));
            }
            line = reader.readLine();
        }
        return symbols;
    }
}

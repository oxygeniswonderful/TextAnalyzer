import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

class GetQueueOfSymbolTest {

    @Test
    void getQueue() throws IOException {
        int actual, expected = 76;
        actual = GetQueueOfSymbol.getQueue(new BufferedReader(new FileReader("text.txt"))).size();
        Assertions.assertEquals(actual, expected);
    }
}
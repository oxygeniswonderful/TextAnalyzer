package org.example.FileForFix;

import java.util.concurrent.BlockingDeque;

public class Q<T> {
    private BlockingDeque<T> blockingDeque;

    public Q() {
    }

    public void putToQ(T element) throws InterruptedException {
        blockingDeque.put(element);
    }

    public T deleteFromQ() throws InterruptedException {
        return blockingDeque.take();
    }
}

package org.example.FileForFix;

public class PutToQThread<T> extends Thread{

    private final Q<T> q;
    private final T element;

    public PutToQThread(Q<T> q, T element) {
        this.q = q;
        this.element = element;
    }

    @Override
    public void run() {
        try {
            q.putToQ(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(element.toString() + " Has been put");
    }
}

package org.example.FileForFix;

public class DeleteFromQThread<T> extends Thread{
    private final Q<T> q;
    private T element;

    public DeleteFromQThread(Q<T> q) {
        this.q = q;
    }

    public T getElement() {
        run();
        return element;
    }

    @Override
    public void run() {
        try {
            element = q.deleteFromQ();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(element.toString() + " Has been deleted");
    }
    }

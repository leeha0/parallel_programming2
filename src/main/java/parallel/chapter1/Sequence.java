package parallel.chapter1;

import parallel.annotation.ThreadSafe;

@ThreadSafe
public class Sequence {

    private int value = 0;

    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " - next = " + sequence.getNext());
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " - next = " + sequence.getNext());
            }
        });

        a.start();
        b.start();

        System.out.println(Thread.currentThread().getName() + " - next = " + sequence.getNext());
    }
}

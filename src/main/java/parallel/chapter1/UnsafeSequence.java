package parallel.chapter1;

import parallel.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {

    private int value = 0;

    /* 유일한 값을 리턴 */
    public int getNext() {
        // 값을 읽고, 읽은 값을 1 더하고, 결과를 다시 기록
        return value++;
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " - next = " + unsafeSequence.getNext());
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " - next = " + unsafeSequence.getNext());
            }
        });

        a.start();
        b.start();

        System.out.println(Thread.currentThread().getName() + " - next = " + unsafeSequence.getNext());
    }
}

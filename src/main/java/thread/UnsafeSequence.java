package thread;

import thread.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext() {
        // 값을 읽고, 읽은 값을 1 더하고, 결과를 다시 기록
        return value++;
    }
}

package parallel.chapter4;

public class PrivateLock {

    private final Object myLock = new Object();
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // weight 변수의 값을 읽거나 변경
        }
    }

    private class Widget {

    }
}

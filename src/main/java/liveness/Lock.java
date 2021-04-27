package liveness;

public class Lock {

    private boolean isLocked = false;
    private Thread lockingThread = null;

    // 락을 얻는 것을 동기화
    // 경합 중인 쓰레드의 진입권을 보장하지 않음
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            // 락이 잠기면 다른 쓰레드들은 모두 블록 상태에 놓임
            // 쓰레드들이 각기 다른 객체의 wait 메서드를 호출하도록 구현하면 특정 쓰레드를 깨울 수 있음
            wait();
        }

        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("호출 쓰레드가 이 락을 소유하지 않았습니다.");
        }

        isLocked = false;
        lockingThread = null;
        notify();
    }
}

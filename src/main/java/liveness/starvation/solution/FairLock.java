package liveness.starvation.solution;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    // 대기 목록
    private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;

        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                // 큐에 위치한 최상위 쓰레드만이 락을 걸 수 있다
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }

            try {
                // 중첩 모니터 락아웃 방지를 위해 synchronized(this) 밖에서 수행
                // 즉, 다른 쓰레드가 unlock 메서드 호출 가능
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
            }
        }
    }

    public void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("호출 쓰레드가 이 락을 소유하지 않음");
        }

        isLocked = false;
        lockingThread = null;

        if (waitingThreads.size() > 0) {
            // 최상단의 QueueObject를 가져와 notify 호출 (공정성)
            waitingThreads.get(0).doNotify();
        }
    }
}

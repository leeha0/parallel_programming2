package liveness.starvation.solution;

public class QueueObject {
    // 일종의 세마포어

    private boolean isNotified = false;

    // doWait 메서드를 호출하는 즉시 선점되는 쓰레드로 인한
    // 신호 소실 문제를 피하기 위해 내부 신호를 저장한다
    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    // 이탈 상태를 조심해야 함
    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    public boolean equals(Object o) {
        return this == o;
    }
}

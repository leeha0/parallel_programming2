package liveness;

public class Synchronizer {

    Lock lock = new Lock();

    public void doSynchronized() throws InterruptedException {
        this.lock.lock();
        // 오랜 수행 시간이 걸리는 작업 수행
        this.lock.unlock();
    }
}

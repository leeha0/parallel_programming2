package liveness.deadlock.solution;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {

    private final ReentrantLock leftChopstick;
    private final ReentrantLock rightChopstick;
    private final Random random;

    public Philosopher(ReentrantLock leftChopstick, ReentrantLock rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                leftChopstick.lock();
                try {
                    if (rightChopstick.tryLock(1000, TimeUnit.MILLISECONDS)) {
                        try {
                            Thread.sleep(random.nextInt(1000));
                        } finally {
                            rightChopstick.unlock();
                        }
                    } else {
                        // 오른쪽 젓가락을 들ㅇ어올리지 못했으므로 포기하고 다시 생각하는 상태로 돌아간다
                    }
                } finally {
                    leftChopstick.unlock();
                }
            }
        } catch (InterruptedException e) {

        }
    }
}

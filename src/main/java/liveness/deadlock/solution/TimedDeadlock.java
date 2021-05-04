package liveness.deadlock.solution;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimedDeadlock {

    static class Friend {

        private final ReentrantLock lock = new ReentrantLock();

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void bow(Friend bower) {
            try {
                lock.lockInterruptibly();
                System.out.format("%s-%s: %s has bowed to me!%n", Thread.currentThread().getName(), this.name,
                    bower.getName());
                bower.bowBack(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // getExclusiveOwnerThread() == Thread.currentThread()
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }

        public void bowBack(Friend bower) {
            try {
                if (lock.tryLock(1000L, TimeUnit.MILLISECONDS)) {
                    System.out.format("%s-%s: %s has bowed back to me!%n", Thread.currentThread().getName(), this.name,
                        bower.getName());
                } else {
                    System.out.format("%s-%s: Stop the bow...%n", Thread.currentThread().getName(), this.name);
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // getExclusiveOwnerThread() == Thread.currentThread()
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}

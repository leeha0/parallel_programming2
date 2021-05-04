package liveness.deadlock.solution;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher2 extends Thread {

    private boolean eating;
    private Philosopher2 left;
    private Philosopher2 right;
    private ReentrantLock table;
    private Condition condition;
    private Random random;

    public Philosopher2(ReentrantLock table) {
        this.table = table;
        eating = false;
        condition = table.newCondition();
        random = new Random();
    }

    public void setLeft(Philosopher2 left) {
        this.left = left;
    }

    public void setRignt(Philosopher2 right) {
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {

        }
    }

    private void think() {
        table.lock();
        try {
            eating = false;
            left.condition.signal();
            right.condition.signal();
        } finally {
            table.unlock();
        }
    }

    private void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating) {
                condition.await();
            }
            eating = true;
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }
}

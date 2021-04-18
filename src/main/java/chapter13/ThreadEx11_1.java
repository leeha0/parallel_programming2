package chapter13;

public class ThreadEx11_1 extends Thread {

    public ThreadEx11_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5 * 1000); // 5초 동안 기다린다.
        } catch (InterruptedException e) {
        }
    }
}

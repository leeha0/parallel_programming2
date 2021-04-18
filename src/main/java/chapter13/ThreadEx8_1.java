package chapter13;

public class ThreadEx8_1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10_000_000; x++) {
            }
        }
    }
}
package chapter13;

public class ThreadEx5_1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.print("소요시간2:" + (System.currentTimeMillis() - ThreadEx5.startTime));
    }
}

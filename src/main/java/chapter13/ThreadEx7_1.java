package chapter13;

public class ThreadEx7_1 extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초간 시간을 지연한다.
            } catch (Exception e) {
            }
        }
    }
}

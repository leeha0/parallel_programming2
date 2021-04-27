package liveness;

public class Deadlock2Starter {

    public static void main(String[] args) {
        // 빠르게 프로그램이 실행되어 정상 종료

        Deadlock2 business = new Deadlock2();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                business.foo();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                business.bar();
            }
        });
        t2.start();
    }
}

package liveness;

public class Deadlock2Starter2 {

    public static void main(String[] args) {
        // 가끔은 정상 수행, 까끔은 데드락
        Deadlock2 business = new Deadlock2();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.foo();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.bar();
                }
            }).start();
        }
    }
}

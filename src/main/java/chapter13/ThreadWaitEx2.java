package chapter13;

public class ThreadWaitEx2 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(); // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook2(table), "COOK1").start();
        new Thread(new Customer2(table, "donut"), "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();

        Thread.sleep(5000); // 5초 후에 강제 종료시킨다.
        System.exit(0); // 프로그램 전체를 종료. (모든 쓰레드가 종료됨)
    }
}

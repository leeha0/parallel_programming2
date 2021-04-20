package chapter13;

public class ThreadWaitEx3 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();

        new Thread(new Cook3(table), "COOK1").start();
        new Thread(new Customer3(table, "donut"), "CUST1").start();
        new Thread(new Customer3(table, "burger"), "CUST2").start();

        Thread.sleep(2000); // 2초 후에 강제 종료시킨다.
        System.exit(0); // 프로그램 전체를 종료. (모든 쓰레드가 종료됨)
    }
}

package chapter13;

public class ThreadWaitEx4 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();

        new Thread(new Cook4(table), "COOK1").start();
        new Thread(new Customer4(table, "donut"), "CUST1").start();
        new Thread(new Customer4(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

package chapter13;

public class Customer4 implements Runnable {

    private Table table;
    private String food;

    public Customer4(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.removeForEx4(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

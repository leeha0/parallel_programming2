package chapter13;

public class Customer3 implements Runnable {

    private Table table;
    private String food;

    public Customer3(Table table, String food) {
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

            table.removeForEx3(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

package parallel;

public class Sample1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                // do something
            }
        });
        thread.start();
        System.out.println("main");
    }
}

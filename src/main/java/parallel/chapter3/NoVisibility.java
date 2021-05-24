package parallel.chapter3;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            // 메인 스레드의 지정한 값을 사용할 수 없는 상황 발생
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new ReaderThread().start();
        }
        number = 42;
        ready = true;
    }
}

package chapter13;

public class ThreadEx1 {

    public static void main(String[] args) {
        // Thread 상속
        ThreadEx1_1 t1 = new ThreadEx1_1();

        // Runnable 구현
        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
        t2.start(); // IllegalThreadStateException 발생
    }
}

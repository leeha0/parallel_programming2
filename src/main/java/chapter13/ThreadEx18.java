package chapter13;

public class ThreadEx18 {

    public static void main(String[] args) {
        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            System.out.println("t1 suspend");
            th1.suspend();
            Thread.sleep(2000);
            System.out.println("t2 suspend");
            th2.suspend();
            Thread.sleep(3000);
            System.out.println("t1 resume");
            th1.resume();
            Thread.sleep(3000);
            System.out.println("t1 stop");
            System.out.println("t2 stop");
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            System.out.println("t3 stop");
            th3.stop();
        } catch (InterruptedException e) {
        }
    }
}

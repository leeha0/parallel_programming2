package chapter13;

public class ThreadEx17 {

    public static void main(String[] args) {
        ThreadEx17_1 th1 = new ThreadEx17_1("*");
        ThreadEx17_1 th2 = new ThreadEx17_1("**");
        ThreadEx17_1 th3 = new ThreadEx17_1("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            System.out.println("th1 suspend");
            Thread.sleep(2000);
            th2.suspend();
            System.out.println("th2 suspend");
            Thread.sleep(3000);
            th1.resume();
            System.out.println("th1 resume");
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            System.out.println("th1 stop");
            System.out.println("th2 stop");
            Thread.sleep(2000);
            th2.stop();
            System.out.println("th2 stop");
        } catch (InterruptedException e) {
        }
    }
}

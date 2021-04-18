package chapter13;

public class ThreadEx15 {

    public static void main(String[] args) {
        RunImplEx15 r = new RunImplEx15();
        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend(); // 쓰레드를 잠시 중단
            System.out.println("th1 suspend");
            Thread.sleep(2000);
            th2.suspend(); // 쓰레드를 잠시 중단
            System.out.println("th2 suspend");
            Thread.sleep(3000);
            th1.resume(); // 쓰레드를 다시 동작
            System.out.println("t1 resume");
            Thread.sleep(3000);
            th1.stop(); // 쓰레드를 강제 종료
            th2.stop(); // 쓰레드를 강제 종료
            System.out.println("th1 stop");
            System.out.println("th2 stop");
            Thread.sleep(2000);
            th3.stop(); // 쓰레드를 강제 종료
            System.out.println("th3 stop");
        } catch (InterruptedException e) {
        }
    }
}

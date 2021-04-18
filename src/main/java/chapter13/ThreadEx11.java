package chapter13;

public class ThreadEx11 {

    public static void main(String[] args) throws Exception {
        ThreadEx11_1 th1 = new ThreadEx11_1("Thread1");
        ThreadEx11_2 th2 = new ThreadEx11_2("Thread2");
        th1.start();
        th2.start();

        // 메인 쓰레드가 종료되어 쓰레드 그룹이 NPE 발생
        // 1초동안 메인 쓰레드를 살려둠
        Thread.sleep(1000);
    }
}

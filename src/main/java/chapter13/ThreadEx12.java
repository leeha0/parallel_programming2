package chapter13;

public class ThreadEx12 {

    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
            th1.sleep(2000); // 실제로 영향을 받는 것은 main 쓰레드
            // Thread.sleep(2000); // static 메서드이므로 다음과 같이 호출하는 것이 맞다.
        } catch (InterruptedException e) {
        }

        System.out.print("<<main 종료>>");
    }
}

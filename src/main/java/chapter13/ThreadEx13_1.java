package chapter13;

public class ThreadEx13_1 extends Thread {

    @Override
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x = 0; x < 2_500_000_000L; x++)
                ; // 시간 지연
            // RUNNABLE 상태에서 interrupt() 호출
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

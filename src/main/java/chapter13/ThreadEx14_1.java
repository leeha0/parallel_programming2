package chapter13;

public class ThreadEx14_1 extends Thread {

    @Override
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                // WAITING 상태에서 interrupt() 호출
                // 1. sleep 상태에서 interrupt() 호출
                // 2. InterruptedException 발생
                // 3. interrupted 상태를 false 초기화
                interrupt(); // 다시 interrupted 상태를 true 변경
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

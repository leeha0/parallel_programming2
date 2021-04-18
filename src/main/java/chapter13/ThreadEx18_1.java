package chapter13;

public class ThreadEx18_1 implements Runnable {

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    public ThreadEx18_1(String name) {
        th = new Thread(this, name);
    }

    @Override
    public void run() {
        String name = th.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " - interrupted");
                }
            } else {
                Thread.yield(); // 바쁜 대기상태에서 다른 쓰레드에게 양보한다.
            }
        }
        System.out.println(name + " - stopped");
    }

    public void suspend() {
        suspended = true;
        th.interrupt(); // 1초의 지연 시간 없이 즉시 일시정지 상태에서 벗어난다.
        System.out.println(th.getName() + " - interrupt() by suspend()");
    }

    public void stop() {
        stopped = true;
        th.interrupt(); // 1초의 지연 시간 없이 즉시 스레드를 멈춘다.
        System.out.println(th.getName() + " - interrupt() by stop()");
    }

    public void resume() {
        suspended = false;
    }

    public void start() {
        th.start();
    }
}

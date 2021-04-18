package chapter13;

public class ThreadEx20 {

    public static void main(String[] args) {
        ThreadEx20_1 gc = new ThreadEx20_1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;

        for (int i = 0; i < 20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;

            // 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60% 이상을 사용했을 경우 gc를 깨운다.
            if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt(); // 잠자고 있는 쓰레드 gc를 깨운다.
                // interrupt() 메서드를 사용하면 gc가 깨어나는 순간에도 main 쓰레드가 메모리를 사용하기 때문에 순간적으로 MAX_MEMORY 넘어선다.
                try {
                    gc.join(100); // 0.1 초 수행
                } catch (InterruptedException e) {}
                // join() 메서드를 사용해서 gc가 작업하는 동안 main 쓰레드를 대기 상태로 만든다.
            }

            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory: " + gc.usedMemory);
        }
    }
}

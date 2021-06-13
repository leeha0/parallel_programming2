package parallel.chapter5;

import java.util.concurrent.BlockingQueue;

import jdk.internal.jline.internal.ShutdownHooks.Task;

public class TaskRunnable implements Runnable {

    BlockingQueue<Task> queue;

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // 인터럽트가 발생한 사실을 저장한다.
            Thread.currentThread().interrupt();
        }
    }

    private void processTask(Task take) {
    }
}

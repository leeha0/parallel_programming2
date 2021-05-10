package parallel.future;

import java.util.concurrent.*;

public class Sample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> "Hello";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        String result = future.get(); // Blocking
        System.out.println(result);
        executorService.shutdown();
    }
}

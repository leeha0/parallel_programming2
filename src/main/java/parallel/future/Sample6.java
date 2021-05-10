package parallel.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Sample6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.completedFuture("Hello World!")
                .thenApply(msg -> msg + " " + " Hi ")
                .thenApplyAsync(msg -> msg + " " + " Hi ", Executors.newSingleThreadExecutor()) // 새로운 스레드에서 동작
                .get();
    }
}

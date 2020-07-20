package thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Sample4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Void result = CompletableFuture.completedFuture("Hello World!")
                .thenAccept(System.out::print)
                .thenAccept(System.out::print)
                .thenAccept(System.out::print)
                .get();
    }
}

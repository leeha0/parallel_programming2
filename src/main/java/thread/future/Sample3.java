package thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Sample3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> completableFuture.complete("Hello World!")).start();

        String result = completableFuture.get(); // Blocking
        System.out.println(result);
    }
}

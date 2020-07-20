package thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Sample5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.completedFuture("A");
        CompletableFuture<String> completableFuture2 = CompletableFuture.completedFuture("B");
        CompletableFuture<String> completableFuture3 = CompletableFuture.completedFuture("C");

        String result = completableFuture1.thenCombine(completableFuture2, (completableFuture1Result, completableFuture2Result) -> completableFuture1Result + " " + completableFuture2Result)
                .thenCombine(completableFuture3, (combineResult, completableFuture3Result) -> combineResult + " " + completableFuture3Result)
                .get();// Blocking

        System.out.println(result);
    }
}

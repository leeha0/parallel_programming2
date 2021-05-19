package parallel.chapter2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SyncAsyncBlockingNonBlocking {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> callback = es.submit(() -> "Hello Async"); // 비동기
        String res = callback.get(); // 동기, 블로킹
        System.out.println("res = " + res);
    }
}

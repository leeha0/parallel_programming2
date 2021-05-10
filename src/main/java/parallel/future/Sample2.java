package parallel.future;

import java.util.concurrent.*;

public class Sample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> firstFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Future<String> secondFuture = executorService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Future<String> thirdFuture = executorService.submit(new Callable<String>() {
                            @Override
                            public String call() throws Exception {
                                return "Finished";
                            }
                        });

                        return thirdFuture.get(); // Blocking
                    }
                });

                return secondFuture.get(); // Blocking
            }
        });

        String result = firstFuture.get(); // Blocking
    }
}

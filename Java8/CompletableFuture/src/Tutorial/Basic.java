package Tutorial;

import java.util.concurrent.*;

public class Basic {

    static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("By ForkJoinPool.commonPool");
        CompletableFuture<String> getProductFromRemoteService =
                CompletableFuture.supplyAsync(() -> {
                    sleep();
                    return "MacBook Air M1 => Executed by " +
                            Thread.currentThread().getName();
                });

        // Blocks the call and then Last Thread is executed
        System.out.println(getProductFromRemoteService.get());
        System.out.println("Last Thread => " + Thread.currentThread().getName());
        System.out.println("******************");

        System.out.println("By Executor Service");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> getProductByExecutor = CompletableFuture.supplyAsync(
                () -> {
                    sleep();
                    return "MacBook Air M1 => Executed by " +
                            Thread.currentThread().getName();
                }, executor
        );

        // Blocks the call and then Last Thread is executed
        System.out.println(getProductByExecutor.get());
        System.out.println("Last Thread => " + Thread.currentThread().getName());
        executor.shutdown();
        System.out.println("******************");


    }
}

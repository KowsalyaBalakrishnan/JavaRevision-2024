package Tutorial;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureChaining {

    static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // thenApply -> returns some result, take output of one chain and it that as it's input
        CompletableFuture<String> finalFutureObject =
                CompletableFuture
                        .supplyAsync(() -> "Hello Kowsalya ")
                        .thenApply(input -> input + "Good Morning!")
                        .thenApply(String::toUpperCase);
        String greet = finalFutureObject.get();
        System.out.println(greet);

        // thenAccept
        CompletableFuture.supplyAsync(() -> "Hi")
                .thenApply(input -> input + " Kowsalya")
                .thenAccept(System.out::println);

        // thenApplyAsync
        CompletableFuture<String> thenApplyAsyncOp = CompletableFuture
                .supplyAsync(() -> {
                    sleep();
                    System.out.println("supplyAsync's Thread => " + Thread.currentThread().getName());
                    return "Hello ";
                }).thenApplyAsync(input -> {
                    System.out.println("thenApply's Thread => " + Thread.currentThread().getName());
                    return input.toUpperCase();
                });
        System.out.println(thenApplyAsyncOp.get());

        // thenApplyAsync with Executor
        System.out.println("thenApplyAsync with Executor");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture
                .supplyAsync(() -> {
                    sleep();
                    System.out.println("supplyAsync's Thread => " + Thread.currentThread().getName());
                    return "Hello ";
                }, executorService)
                .thenApplyAsync(input -> {
                    System.out.println("thenApply's Thread => " + Thread.currentThread().getName());
                    return input.toUpperCase();
                }, executorService)
                .thenAccept(System.out::println);
        System.out.println("******************");
    }
}

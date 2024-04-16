package Tutorial.allOf.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AllOfPracticeWithoutPartitioning {

    static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Prepare Input
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            input.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for (int i : input) {
            CompletableFuture<Integer> multiplesOfFive = getMultiplesOfFive(i, executorService);
            futures.add(multiplesOfFive);
        }

        CompletableFuture<Void> allOfVoid = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        CompletableFuture<List<Integer>> listCompletableFuture = allOfVoid.thenApply(
                data -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );

        List<Integer> result = listCompletableFuture.get();
        result.forEach(System.out::println);
        executorService.shutdown();
    }

    private static CompletableFuture<Integer> getMultiplesOfFive(int number, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Started => " + Thread.currentThread().getName());
                    sleep();

                    System.out.println("Operating Number " + number + " by Thread => " + Thread.currentThread().getName());
                    System.out.println("Completed => " + Thread.currentThread().getName());
                    return number * 5;
                },
                executorService
        ).exceptionally(ex -> {
            System.out.println("Exception Occurred => " + ex.getMessage());
            return null;
        });
    }
}

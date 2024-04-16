package Tutorial.allOf.practice;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AllOfPractice {

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
        List<List<Integer>> partitionedList = ListUtils.partition(input, 5);
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();

        for (List<Integer> partitioned : partitionedList) {
            CompletableFuture<List<Integer>> multiplesOfFive = getMultiplesOfFive(partitioned, executorService);
            futures.add(multiplesOfFive);

        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        CompletableFuture<List<List<Integer>>> listCompletableFuture = allOf.thenApply(data ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        List<List<Integer>> partitionedResults = listCompletableFuture.get();
        System.out.println("Final Output");
        partitionedResults.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("**************");
        executorService.shutdown();
    }

    private static CompletableFuture<List<Integer>> getMultiplesOfFive(List<Integer> numbers, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(
                () -> {
                    List<Integer> multipliedList = new ArrayList<>();
                    System.out.println("Started => " + Thread.currentThread().getName());
                    sleep();
                    for (Integer number : numbers) {
                        System.out.println("Operating Number " + number + " by Thread => " + Thread.currentThread().getName());
                        multipliedList.add(number * 5);
                    }
                    System.out.println("Completed => " + Thread.currentThread().getName());
                    return multipliedList;
                },
                executorService
        );
    }
}

package ConcurrentOperationOnPartitionedList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureExample {
    public static void main(String[] args) {

        // Sample list of 1000 records
        List<Integer> records = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            records.add(i);
        }

        // Create a custom executor with a fixed number of threads
        int numThreads = 2;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Process records asynchronously in batches
        List<CompletableFuture<String>> batchFutures = new ArrayList<>();
        int batchSize = 5;

        for (int startIndex = 0; startIndex < records.size(); startIndex += batchSize) {
            List<Integer> batch = records.subList(startIndex, startIndex + batchSize);
            CompletableFuture<String> batchFuture = processBatch(batch, executor);
            batchFutures.add(batchFuture);
        }

        // Wait for all batch tasks to complete
        AtomicInteger count = new AtomicInteger();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(batchFutures.toArray(new CompletableFuture[0]));

        // Shutdown the executor
        executor.shutdown();
    }

    private static CompletableFuture<String> processBatch(List<Integer> batch, ExecutorService executor) {
        System.out.println("In");
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing runAsync() by Thread => " + Thread.currentThread().getName());
            for (Integer record : batch) {

                System.out.println("Processing record " + record + " by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "DONE";
        }, executor);
    }
}

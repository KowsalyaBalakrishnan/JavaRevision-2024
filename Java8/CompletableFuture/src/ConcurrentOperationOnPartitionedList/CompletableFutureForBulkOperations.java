package ConcurrentOperationOnPartitionedList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureForBulkOperations {

    public static void main(String[] args) {

        // 25 Records
        List<Integer> records = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            records.add(i);
        }

        // Executors Service
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CompletableFuture<String>> futures = new ArrayList<>();

        int batchSize = 5;
        for (int i = 0; i < records.size(); i += batchSize) {
            List<Integer> batch = records.subList(i, Math.min(i + batchSize, records.size()));
            CompletableFuture<String> future = processBatchRecords(batch, executorService);
            futures.add(future);
        }

        CompletableFuture<Void> futureObjectList =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        futureObjectList.join();

        System.out.println("Executed by Main => " + Thread.currentThread().getName());
        executorService.shutdown();

    }

    private static CompletableFuture<String> processBatchRecords(List<Integer> batch, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing Batch by Thread => " + Thread.currentThread().getName());
            batch.forEach(record -> System.out.println("Row " + record + " is executed by " + Thread.currentThread().getName()));
            return "completed";
        }, executorService);
    }
}

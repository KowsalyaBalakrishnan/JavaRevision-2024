import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class JoinFutureResults {

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void executionThread() {
        System.out.println("Thread execution - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            String stringToPrint = "Educative";
            System.out.println("----\nsupplyAsync first future - " + stringToPrint);
            executionThread();
            return stringToPrint;
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            String stringToPrint = "Edpresso";
            System.out.println("----\nsupplyAsync second future - " + stringToPrint);
            executionThread();
            return stringToPrint;
        });

        List<CompletableFuture<String>> completableFutures = Arrays.asList(completableFuture1, completableFuture2);

        CompletableFuture<Void> resultantCf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<String>> allFutureResults = resultantCf.thenApply(t ->
                completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList()));

        System.out.println("Result - " + allFutureResults.get());
        sleep(1000);
    }
}

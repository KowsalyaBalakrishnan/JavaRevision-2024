package Tutorial.allOf.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AllOfMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> langList = Arrays.asList("EN", "ES", "SN", "XX");

        List<CompletableFuture<Greet>> completableFutures =
                langList.stream()
                        .map(AllOfMain::getGreeting)
                        .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<Greet>> allCompletableFuture =
                allFutures
                        .thenApply(future ->
                                completableFutures.stream()
                                        .map(CompletableFuture::join)
                                        .collect(Collectors.toList())
                        );

        List<Greet> outputs = allCompletableFuture.get();
        outputs.forEach(System.out::println);

    }

    private static String getGreet(String lang) {
        switch (lang) {
            case "EN":
                return "Hello";
            case "ES":
                return "Hola";
            case "SN":
                return "Ayubovan";
            default:
                throw new IllegalArgumentException("Invalid lang param");
        }
    }

    private static CompletableFuture<Greet> getGreeting(String lang) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread => " + Thread.currentThread().getName());
            try {
                System.out.println("Task execution started");
                Thread.sleep(2000);
                System.out.println("Task execution stopped");
            } catch (InterruptedException e) {
                System.out.println("Exception Occurred => " + e.getMessage());
            }
            return new Greet(getGreet(lang));
        }).exceptionally( ex -> {
            System.out.println("Something went wrong : " + ex);
            return null;
        });
    }
}

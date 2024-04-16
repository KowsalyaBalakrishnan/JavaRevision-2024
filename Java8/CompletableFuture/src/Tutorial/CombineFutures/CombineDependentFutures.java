package Tutorial.CombineFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineDependentFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Nested Future -> Have to be flattened
        CompletableFuture<CompletableFuture<Double>> nestedFutures =
                getUsersDetail("1").thenApply(CombineDependentFutures::getCreditRating);

        // Flattening using thenCompose
        CompletableFuture<Double> finalResultOfDependentFutures = getUsersDetail("1")
                .thenCompose(CombineDependentFutures::getCreditRating);
        Double credit = finalResultOfDependentFutures.get();
        System.out.println(credit);

    }

    static CompletableFuture<String> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return "Kowsalya";
        });
    }

    static CompletableFuture<Double> getCreditRating(String user) {
        return CompletableFuture.supplyAsync(() -> {
            return 100.5;
        });
    }
}

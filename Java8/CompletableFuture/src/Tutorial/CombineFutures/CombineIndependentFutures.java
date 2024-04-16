package Tutorial.CombineFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineIndependentFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> weight = CompletableFuture.supplyAsync(() -> 70);
        CompletableFuture<Integer> height = CompletableFuture.supplyAsync(() -> 160);

        CompletableFuture<Integer> bmi = weight.thenCombine(height, (weightResult, heightResult) -> {
            System.out.println("Weight => " + weightResult + " Height => " + heightResult);
            int heightInMeter = heightResult / 100;
            return weightResult / (heightInMeter * heightInMeter);
        });

        System.out.println(bmi.get());

    }
}

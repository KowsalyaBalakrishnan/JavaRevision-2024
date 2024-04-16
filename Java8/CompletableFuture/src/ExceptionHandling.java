import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandling {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String name = "";
        CompletableFuture<String> checkString = CompletableFuture.supplyAsync(() -> {
            if (name == null || name.isBlank()) {
                throw new NullPointerException("Name is Null");
            }
            return "Hello " + name;
        }).handle((message, ex) -> message != null ? message : "Hello Stranger");

        CompletableFuture.allOf(checkString).join();

        System.out.println(checkString.get());



    }
}

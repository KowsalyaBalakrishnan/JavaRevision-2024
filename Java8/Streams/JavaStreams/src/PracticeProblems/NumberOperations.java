package PracticeProblems;

import java.util.*;
import java.util.stream.IntStream;

public class NumberOperations {
    public static void main(String[] args) {

        // Sum
        IntStream numbers = IntStream.range(1, 11);
        int boxedSum = numbers.boxed()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(boxedSum);

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numberList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        int reducedSum1 = numberList.stream()
                .mapToInt(Integer::intValue)
                .reduce(1, Integer::sum);
        System.out.println(reducedSum1);

        int reducedSum2 = numberList.stream()
                .mapToInt(Integer::intValue)
                .reduce(2, (a, b) -> a + b);
        System.out.println(reducedSum2);

        // Average
        OptionalDouble average = numberList.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        average.ifPresentOrElse(System.out::println, null);

        OptionalLong max = numberList.stream()
                .mapToLong(Integer::longValue)
                .max();
        max.ifPresent(System.out::println);

        List<Integer> emptyList = new ArrayList<>();
        double oredElse = emptyList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(-1);
        System.out.println(oredElse);

        // Count
        long count = numberList.stream().mapToInt(Integer::intValue).count();
        System.out.println(count);

        // Max value
        OptionalInt maxValue = numberList.stream().mapToInt(Integer::intValue).max();
        maxValue.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        // Min value
        Optional<Integer> minValue = numberList.stream().min(Comparator.comparing(Integer::intValue));
        minValue.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        // Average terminal operation
        List<Double> doubles = Arrays.asList(1.1, 1.7, 1.3);
        OptionalDouble averageTerminalOperation = doubles.stream().mapToDouble(Double::doubleValue).average();
        averageTerminalOperation.ifPresentOrElse(System.out::println, () -> System.out.println("Empty Value"));

        // Double as Int sum
        int doubleToIntSum = doubles.stream().mapToInt(Double::intValue).sum();
        System.out.println(doubleToIntSum);
    }
}

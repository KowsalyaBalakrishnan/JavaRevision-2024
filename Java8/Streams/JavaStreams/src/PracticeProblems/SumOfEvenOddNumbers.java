package PracticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SumOfEvenOddNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 3, 4, 6, 7, 8, 10, 11);

        Predicate<Integer> oddOrEven = number -> number % 2 == 0;
        Map<Boolean, Integer> partitionedSum =
                numbers.stream()
                .collect(
                        Collectors.partitioningBy(oddOrEven, Collectors.reducing(0, Integer::sum))
                );

        for (Map.Entry<Boolean, Integer> entry : partitionedSum.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}

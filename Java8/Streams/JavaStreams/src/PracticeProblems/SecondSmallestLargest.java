package PracticeProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondSmallestLargest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        // Second Smallest
        numbers.stream()
                .sorted()
                .skip(1)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No Value"));

        // Second Largest
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No Value"));
    }
}

package PracticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemovingDuplicates {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        List<Integer> distinctListOne = numbers.stream().distinct().collect(Collectors.toList());
        distinctListOne.forEach(System.out::println);

        System.out.println("**********");

        List<Integer> distinctListTwo = numbers.stream().mapToInt(Integer::intValue).distinct().boxed().collect(Collectors.toList());
        distinctListTwo.forEach(System.out::println);
    }
}

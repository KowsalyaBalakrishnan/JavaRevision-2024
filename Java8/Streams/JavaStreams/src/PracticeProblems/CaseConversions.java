package PracticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CaseConversions {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", " world!", "Hi ", " There ");
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .map(String::trim)
                .collect(Collectors.toList());
        upperCaseWords.forEach(System.out::println);

        System.out.println("**********************");

        List<String> lowerCaseWords = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        lowerCaseWords.forEach(System.out::println);
    }
}

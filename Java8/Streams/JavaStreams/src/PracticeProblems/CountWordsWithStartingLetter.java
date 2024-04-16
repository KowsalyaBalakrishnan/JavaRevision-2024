package PracticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountWordsWithStartingLetter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the letter : ");
        String startingLetter = scanner.next();

        Predicate<String> searchPredicate = word -> word.startsWith(startingLetter);
        long count = words.stream()
                .filter(searchPredicate)
                .count();
        System.out.println("Number of colors starting with '" + startingLetter + "' => " + count);
    }
}

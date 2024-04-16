package StreamOperations;

import Common.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComparisonOperations {
    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployees();

        //Sort - Asc
        employees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("*****************Sort Asc********************");
        employees.forEach(System.out::println);

        //Sort - Desc
        employees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.println("*****************Sort Desc********************");
        employees.forEach(System.out::println);

        // Sort Numbers
        List<Integer> numbers = Arrays.asList(4, 5, 3, 1, 2);
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // Sort Names
        List<String> names = Arrays.asList("Gomathi", "Kowsalya", "ChandraMohan");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // Min value
        Optional<Employee> minSalaried = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println("*****************Min Salary********************");
        // minSalaried = Optional.empty();
        minSalaried.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        // Max value
        Optional<Employee> maxSalaried = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("*****************Max Salary********************");
        //maxSalaried = Optional.empty();
        maxSalaried.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));

        // Distinct Salary
        List<Double> distinctSalaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("*****************Distinct Salary********************");
        distinctSalaries.forEach(System.out::println);

        // Distinct Employee [It uses equals() internally. like we overridden equals() by salary, it gives distinct employee based on salary
        List<Employee> distinctEmployees = employees.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("*****************Distinct Employees********************");
        distinctEmployees.forEach(System.out::println);


        // allMatch, anyMatch, noneMatch
        boolean allMatch = employees.stream()
                .map(Employee::getId)
                .allMatch(empId -> empId % 2 == 0);
        System.out.println("allMatch => " + allMatch);

        boolean anyMatch = employees.stream()
                .map(Employee::getId)
                .anyMatch(empId -> empId % 2 == 0);
        System.out.println("anyMatch => " + anyMatch);


        Predicate<String> isAlpha = name -> {
            char[] nameCharArray = name.toCharArray();
            boolean flag = false;
            for (char c : nameCharArray) {
                boolean alphabetic = Character.isAlphabetic(c);
                if (!alphabetic) {
                    flag = true;
                    break;
                }
            }
            return flag;
        };

        // noneMatch's predicate should return false in order to verify that none of the collections are matches => returns true as result
        boolean noneMatch = employees.stream()
                .map(Employee::getName)
                .noneMatch(isAlpha::test);
        System.out.println("noneMatch => " + noneMatch);

    }


}

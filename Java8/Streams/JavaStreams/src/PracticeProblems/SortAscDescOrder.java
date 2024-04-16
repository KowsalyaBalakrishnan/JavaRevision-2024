package PracticeProblems;

import Common.Department;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAscDescOrder {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");

        List<String> ascOrder = words.stream()
                .sorted()
                .collect(Collectors.toList());
        ascOrder.forEach(System.out::println);

        System.out.println("*******************");

        List<String> descOrder = words.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        descOrder.forEach(System.out::println);

        System.out.println("*******************");

        Department cse = new Department(1, "CSE");
        Department eee = new Department(2, "EEE");
        Department ece = new Department(3, "ECE");

        System.out.println("*******************");
        List<Department> departments = Arrays.asList(eee, cse, ece);

        // Comparator for Department class
        Comparator<Department> departmentComparator = Comparator.comparing(Department::getName);

        List<Department> reverseDepartment = departments.stream()
                .sorted(departmentComparator.reversed())
                .collect(Collectors.toList());
        reverseDepartment.forEach(System.out::println);

        System.out.println("*******************");
        List<Department> ascendingDepartment = departments.stream()
                .sorted(departmentComparator)
                .collect(Collectors.toList());
        ascendingDepartment.forEach(System.out::println);

    }
}

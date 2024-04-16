package StreamOperations;

import Common.Department;
import Common.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvancedCollect {

    public static void main(String[] args) {

        IntStream inputStream = IntStream.range(1, 11); // Convert to Wrapper object as it is primitive

        // Boxed + PartitioningBy
        Predicate<Integer> predicate = num -> num % 2 == 0;
        Map<Boolean, List<Integer>> isEven = inputStream.boxed()
                .collect(Collectors.partitioningBy(predicate));
        System.out.println("Partitioned List");

        for (Map.Entry<Boolean, List<Integer>> entry : isEven.entrySet()) {
            entry.getValue().forEach(data -> System.out.print(data + " "));
            System.out.print(entry.getKey() + " => ");
            System.out.println();
        }

        System.out.println("***********Grouping************");

        //Grouping By
        Department cse = new Department(1, "CSE");
        Department eee = new Department(2, "EEE");
        Department ece = new Department(3, "ECE");

        Student s1 = new Student(100, "Kowsalya", cse);
        Student s2 = new Student(200, "Rifana", cse);
        Student s3 = new Student(300, "Karthika", eee);
        Student s4 = new Student(400, "Dharani", eee);
        Student s5 = new Student(500, "Cathey", ece);
        Student s6 = new Student(600, "Anjana", ece);

        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6);

        Map<String, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(student -> student.getDepartment().getName()));


        for (Map.Entry<String, List<Student>> entry : collect.entrySet()) {
            System.out.print(entry.getKey() + " => ");
            entry.getValue().forEach(data -> System.out.println(data + " "));
        }

        // Mapping By
        System.out.println("***********Grouping + Mapping************");

        Map<String, Set<String>> groupedStudentsByName = students.stream()
                .collect(Collectors.groupingBy(student -> student.getDepartment().getName(),
                        Collectors.mapping(Student::getName, Collectors.toSet())));
        for (Map.Entry<String, Set<String>> entry : groupedStudentsByName.entrySet()) {
            System.out.print(entry.getKey() + " => ");
            entry.getValue().forEach(data -> System.out.println(data + " "));
        }

        // Counting
        System.out.println("***********Grouping + Count************");
        Map<String, Long> groupedStudentsCount = students.stream()
                .collect(Collectors.groupingBy(student -> student.getDepartment().getName(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : groupedStudentsCount.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Grouping with Max and Min
        System.out.println("***********Grouping + MaxMin************");
        Map<String, Optional<Student>> maxMin = students.stream()
                .collect
                        (Collectors.groupingBy
                                (
                                        student -> student.getDepartment().getName(),
                                        Collectors.maxBy(Comparator.comparing(Student::getId))
                                )
                        );

        for (Map.Entry<String, Optional<Student>> entry : maxMin.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Grouping with max and min -> by department find the max id student
        System.out.println("***********Grouping + MaxMin + Collecting and Then************");
        Map<String, String> groupedByID = students.stream()
                .collect(
                        Collectors.groupingBy(
                                student -> student.getDepartment().getName(),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getId)),
                                        student -> {
                                            Student s;
                                            if (student.isPresent()) {
                                                s = student.get();
                                                return s.getName();
                                            }
                                            return null;
                                        }
                                )
                        )
                );

        for (Map.Entry<String, String> entry : groupedByID.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }


    }
}

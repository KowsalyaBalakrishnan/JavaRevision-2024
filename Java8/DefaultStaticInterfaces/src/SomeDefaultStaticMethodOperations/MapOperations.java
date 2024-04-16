package SomeDefaultStaticMethodOperations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOperations {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.putIfAbsent("D", 4);
        map.putIfAbsent("C", 5);    // Won't put

        map.computeIfAbsent("E", k -> 5 * 10);
        map.computeIfPresent("D", (key, value) -> value * 10);

        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        Integer value = map.getOrDefault("F", 0);
        System.out.println(value);


        //Sort
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
        collect.forEach(System.out::println);


        System.out.println("Student Comparator in Map");
        Map<Integer, Student> studentMap = new HashMap<>();
        Student student1 = new Student(1, "Kowsalya");
        Student student2 = new Student(2, "ChandraMohan");

        studentMap.put(1, student1);
        studentMap.put(2, student2);

        Comparator<Map.Entry<Integer, Student>> studentComparator =
                Map.Entry.comparingByValue(Comparator.comparing(Student::getName));
        studentMap.entrySet().stream()
                .sorted(studentComparator.reversed())
                .forEach(System.out::println);
    }
}

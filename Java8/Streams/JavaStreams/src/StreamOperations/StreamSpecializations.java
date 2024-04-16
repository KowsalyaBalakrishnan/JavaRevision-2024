package StreamOperations;

import Common.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamSpecializations {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployees();

        // Primitive Streams
        OptionalInt maxId = employees.stream()
                .mapToInt(Employee::getId)
                .max();
        maxId.ifPresentOrElse(System.out::println, () -> System.out.println("No Max"));

        OptionalInt minNumber = IntStream.range(0, 10)
                .min();
        minNumber.ifPresentOrElse(System.out::println, () -> System.out.println("No Min"));


        // Specializations
        OptionalDouble average = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average();
        average.ifPresent(System.out::println);

        double reducedAmount = employees.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0, Double::sum);
        System.out.println(reducedAmount);
    }
}

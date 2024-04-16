package StreamOperations;

import Common.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class BasicOperations {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployees();

        // forEach
        System.out.println("*****************ForEach************************");
        employees.forEach(employee -> Employee.incrementSalary(100));
        employees.forEach(System.out::println);

        // Map
        List<Integer> employeeIds = employees.stream()
                .map(Employee::getId)
                .collect(Collectors.toList());
        System.out.println("*****************Map************************");
        employeeIds.forEach(System.out::println);

        // Filter
        List<Employee> filteredSalary = employees.stream()
                .filter(employee -> employee.getSalary() > 200300.0)
                .collect(Collectors.toList());
        System.out.println("****************Filter*************************");
        filteredSalary.forEach(System.out::println);

        // Reset Salary
        employees.forEach(employee -> Employee.resetSalary(100));
        System.out.println("******************Reset Salary***********************");
        employees.forEach(System.out::println);

        // Add Employee
        Employee.addEmployee(new Employee(4, "Girish", 300000));
        System.out.println("***************Add Employee**********************");
        Employee.getEmployees().forEach(System.out::println);

        //findFirst
        Employee firstEmployee = Employee.getEmployees().stream()
                .filter(employee -> employee != null && employee.getSalary() > 200000)
                .findFirst()
                .orElse(null);
        System.out.println("*****************Find First*********************");
        System.out.println(firstEmployee);

        // toArray()
        Employee[] employeeArray = Employee.getEmployees().toArray(Employee[]::new);
        System.out.println("******************toArray[]***********************");
        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }
    }
}

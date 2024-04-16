package MediumBlogUseCaseProblems;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemSolutions {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // All Details
        // employeeList.forEach(System.out::println);

        // List all distinct project in non-ascending order
        Comparator<Project> projectNameComparator = Comparator.comparing(Project::getName);
        List<Project> distinctProjects = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .sorted(projectNameComparator.reversed())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("List all distinct project in non-ascending order");
        distinctProjects.forEach(System.out::println);
        System.out.println("*************************************");

        // Print full name of any employee whose firstName starts with ‘A’.
        List<String> fullNames = employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());

        System.out.println("Print full name of any employee whose firstName starts with ‘A’");
        fullNames.forEach(System.out::println);
        System.out.println("*************************************");

        // List of all employee who joined in year 2023
        List<Employee> employees2023 = employeeList.stream()
                .filter(employee -> employee.getId().substring(0, 4).equalsIgnoreCase("2023"))
                .collect(Collectors.toList());
        System.out.println("List of all employee who joined in year 2023");
        employees2023.forEach(System.out::println);
        System.out.println("*************************************");

        // Sort employees based on firstName, for same firstName sort by salary
        Comparator<Employee> firstNameAscComparator = Comparator.comparing(Employee::getFirstName);
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(firstNameAscComparator)
                .collect(Collectors.toList());
        System.out.println("Sort employees based on firstName, for same firstName sort by salary");
        sortedEmployees.forEach(System.out::println);
        System.out.println("*************************************");

        // Print names of all employee with 3rd highest salary
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the n value => ");
        int n = scanner.nextInt();*/

        Map<Integer, List<Employee>> groupBySalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        List<Integer> salaryOrders = groupBySalary.keySet().stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());

        Integer salary = salaryOrders.get(3 - 1);
        List<Employee> employees = groupBySalary.get(salary);

        System.out.println("Print names of all employee with 3rd highest salary");
        for (Employee e : employees) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }

        System.out.println("*************************************");

        // Print min salary
        Optional<Employee> min = employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println("Print min salary");
        min.ifPresent(System.out::println);
        System.out.println("*************************************");

        // Print list of all employee with min salary
        System.out.println("Print list of all employee with min salary");
        Optional<Integer> minSalary = groupBySalary.keySet()
                .stream()
                .sorted()
                .findFirst();
        if (minSalary.isPresent()) {
            List<Employee> minSalariedEmployees = groupBySalary.get(minSalary.get());
            minSalariedEmployees.forEach(System.out::println);
        }

        System.out.println("*************************************");

        // List of people working on more than 2 projects
        List<String> employeesWorkingMoreThan2Projects = employeeList.stream()
                .filter(employee -> employee.getProjects().size() >= 2)
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());
        System.out.println("List of people working on more than 2 projects");
        employeesWorkingMoreThan2Projects.forEach(System.out::println);
        System.out.println("*************************************");

        // Count of total laptops assigned to the employees
        System.out.println("Count of total laptops assigned to the employees");
        Map<String, List<Integer>> laptopCountOfEmployee = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> employee.getFirstName() + " " + employee.getLastName(),
                                Collectors.mapping(Employee::getTotalLaptopsAssigned, Collectors.toList())
                        )
                );
        for (Map.Entry<String, List<Integer>> entry : laptopCountOfEmployee.entrySet()) {
            System.out.println(entry.getKey() + " has " + entry.getValue().get(0) + " laptops assigned");
        }
        System.out.println("*************************************");

        // Count of all projects with Robert Downey Jr as PM
        System.out.println("Count of all projects with Robert Downey Jr as PM");
        long projectCount = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .count();
        System.out.println("Project Count of Robert Downey Jr = " + projectCount);
        System.out.println("*************************************");

        // List of all people working with Robert Downey Jr
        System.out.println("List of all people working with Robert Downey Jr");
        List<String> robertDowneyJrProjects = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .map(Project::getName)
                .collect(Collectors.toList());
        List<String> employeesUnderRobertPM = employeeList.stream()
                .filter(employee -> employee.getProjects().stream().anyMatch(project -> robertDowneyJrProjects.contains(project.getName())))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());
        employeesUnderRobertPM.forEach(System.out::println);
        System.out.println("*************************************");

        // Create a map based on the data => the key should be the year of joining, and value should be list of all the employees who joined the particular year
        Map<String, List<Employee>> yearEmployeeJoined = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4)));
        System.out.println("Map of Joining Year and Employees");
        yearEmployeeJoined.forEach((k, v) -> {
            System.out.println("Year :: " + k);
        v.forEach(System.out::println);
            System.out.println("**");
        });
        System.out.println("*************************************");

        // Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year
        Map<String, Long> yearEmployeeJoinedCount = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4), Collectors.counting()));
        System.out.println("Map of Joining Year and Employees Count");
        yearEmployeeJoinedCount.forEach((k, v) -> {
            System.out.println("Year :: " + k + " Joined :: " + v);
        });
        System.out.println("*************************************");
    }
}

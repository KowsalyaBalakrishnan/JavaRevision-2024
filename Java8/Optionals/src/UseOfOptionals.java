import Commons.Employee;

import java.util.*;

public class UseOfOptionals {

    static List<Employee> employees = new ArrayList<>();

    static {
        Employee employee1 = new Employee(1, "Kowsalya", "Chennai");
        Employee employee2 = new Employee(2, "Nethra", "Bangalore");
        Employee employee3 = new Employee(3, "Rifana", "Hyderabad");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    public static void main(String[] args) {

        Optional<Employee> employeeById = findEmployeeById(11);

        // If present do something consumer action
        System.out.println("ifPresent()");
        employeeById.ifPresent(System.out::println);
        System.out.println("************");

        // Return Default in case of Optionals
        System.out.println("ifPresentOrElse");
        employeeById.ifPresentOrElse(System.out::println, UseOfOptionals::getDefaultValueForEmployee);
        System.out.println("************");

        // Instead of get, check if is there, or else set a default employee to avoid null => instead of returning null
        System.out.println("orElse");
        Employee employee = employeeById.orElse(new Employee(0, "", ""));
        System.out.println(employee);
        System.out.println("************");

        // Throw if not found
        System.out.println("orElseThrow");
        /*Employee employee1 = employeeById.orElseThrow();
        System.out.println(employee1);*/
        System.out.println("************");

        // Get another value if first search is not found
        System.out.println("Get another value if first search is not found");
        Employee employee2 = employeeById.orElseGet(() -> findEmployeeById(200).orElse(new Employee(0, "", "")));
        System.out.println(employee2);
        System.out.println("************");

        // Get another value if first search is not found and throw if 2nd value is also not found
        System.out.println("Get another value if first search is not found and throw if 2nd value is also not found");
        Employee employee3 = employeeById.orElseGet(
                () -> findEmployeeById(3)
                        .orElseThrow(() -> new NoSuchElementException("Custom No value exception"))
        );
        System.out.println(employee3);
        System.out.println("************");

    }

    static Optional<Employee> findEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    static void getDefaultValueForEmployee() {
        System.out.println("No Data");
    }
}
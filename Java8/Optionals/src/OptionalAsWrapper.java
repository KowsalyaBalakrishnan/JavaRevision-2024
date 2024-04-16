import Commons.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalAsWrapper {

    static List<Employee> employees = new ArrayList<>();

    static {
        Employee employee1 = new Employee(1, "Kowsalya", "Chennai");
        Employee employee2 = new Employee(2, "Nethra", "Bangalore");
        Employee employee3 = new Employee(3, "Rifana", "Hyderabad");
        Employee employee4 = new Employee(4, "ChandraMohan", "Chennai");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

    }

    public static void main(String[] args) {

        Optional<List<Employee>> employeeLocationStatus = getEmployeesForLocation("Noida");

        System.out.println("orElse");
        List<Employee> employeeList = employeeLocationStatus.orElse(new ArrayList<>());
        employeeList.forEach(System.out::println);
        System.out.println("###########");

        System.out.println("orElseGet");
        List<Employee> employees1 = employeeLocationStatus.orElseGet(() -> getEmployeesForLocation("Hyderabad").orElse(new ArrayList<>()));
        employees1.forEach(System.out::println);
        System.out.println("###########");

        System.out.println("orElseGet NestedLoop");
        List<Employee> employees2 = employeeLocationStatus.orElseGet(
                () -> getEmployeesForLocation("Kerala").orElseGet(() -> getEmployeesForLocation("Bangalore").orElse(new ArrayList<>()))
        );
        employees2.forEach(System.out::println);
        System.out.println("###########");

    }

    static Optional<List<Employee>> getEmployeesForLocation(String location) {
        List<Employee> employeeList = employees.stream().filter(employee -> employee.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
        if (!employeeList.isEmpty()) {
            return Optional.of(employeeList);
        } else {
            return Optional.empty();
        }
    }

}

package Common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee {

    private int id;
    private String name;
    private double salary;

    private static List<Employee> employees;

    static {
        Employee jeffBezos = new Employee(1, "JeffBezos", 100000.0);
        Employee billGates = new Employee(2, "BillGates", 200000.0);
        Employee markZuckerberg = new Employee(3, "MarkZuckerberg", 300000.0);
        Employee newEmployee = new Employee(4, "XYZ", 300000.0);

        employees = Arrays.asList(jeffBezos, billGates, markZuckerberg, newEmployee);
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void incrementSalary(double merit) {
        employees = employees.stream()
                .peek(employee -> employee.setSalary(employee.getSalary() + merit))
                .collect(Collectors.toList());
    }

    public static void resetSalary(double merit) {
        employees = employees.stream()
                .peek(employee -> employee.setSalary(employee.getSalary() - merit))
                .collect(Collectors.toList());
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
}
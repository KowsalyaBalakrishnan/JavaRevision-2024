package org.patterns.design.gof.creational.prototype;

public class PrototypeDriverMain {

    public static void main(String[] args) {

        Address address = new Address();
        address.setCity("Coimbatore");

        Student student = new CSEStudent();
        student.setAddress(address);
        student.department();
        System.out.println("Address before Cloning => " + student.getAddress().hashCode());

        // Clone
        Student clonedStudent;
        try {
            clonedStudent = student.clone();
            System.out.print("Cloning Result => ");
            clonedStudent.department();
            System.out.println("Address after Cloning => " + clonedStudent.getAddress().hashCode());

            clonedStudent.getAddress().setCity("Chennai");

            System.out.println("Address changed");
            System.out.println("Address before Cloning => " + student.getAddress().hashCode());
            System.out.println("Address after Cloning => " + clonedStudent.getAddress().hashCode());


        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        Student student1 = new ITStudent();
        System.out.println(student1.getCollege());
        student1.department();

        try {
            Student student2 = student1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}

package org.patterns.design.gof.creational.builder.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.patterns.design.gof.creational.builder.request.Address;
import org.patterns.design.gof.creational.builder.service.UserResponseBuilder;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class UserResponseDTO {

    private String fullName;
    private int age;
    private String address;

    // Note : We have private setters to achieve immutability and do not have all args constructor
    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    // Expose by creating a new Builder Object
    public static UserResponseBuilder getBuilder() {
        return new UserResponseBuilderImpl();
    }

    // Inner class has access to the outer class variables
    public static class UserResponseBuilderImpl implements UserResponseBuilder {

        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private UserResponseDTO userResponseDTO;

        @Override
        public UserResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public UserResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public UserResponseBuilder birthDate(LocalDate birthDate) {
            this.age = Period.between(birthDate, LocalDate.now()).getYears();
            return this;
        }

        @Override
        public UserResponseBuilder address(Address address) {
            this.address = address.toString();
            return this;
        }

        @Override
        public UserResponseDTO build() {
            this.userResponseDTO = new UserResponseDTO();
            this.userResponseDTO.setFullName(this.firstName + " " + this.lastName); // Modify the request if required for response
            this.userResponseDTO.setAddress(this.address);
            this.userResponseDTO.setAge(this.age);
            return this.userResponseDTO;
        }

        @Override
        public UserResponseDTO getUserResponse() {
            return this.userResponseDTO;
        }
    }

    @Override
    public String toString() {
        return "Name : " + fullName + "\n" +
                "Age: " + age + "\n" +
                "Address: " + address + "\n";
    }
}

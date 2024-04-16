package org.patterns.design.gof.creational.builder.service;

import org.patterns.design.gof.creational.builder.request.Address;
import org.patterns.design.gof.creational.builder.response.UserResponseDTO;

import java.time.LocalDate;
import java.time.Period;

public class UserResponseBuilderImpl implements UserResponseBuilder {

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
        this.userResponseDTO = new UserResponseDTO(
                this.firstName + " " + this.lastName,
                this.age,
                this.address);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUserResponse() {
        return this.userResponseDTO;
    }
}

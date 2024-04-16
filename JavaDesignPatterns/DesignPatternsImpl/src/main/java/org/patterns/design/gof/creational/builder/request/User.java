package org.patterns.design.gof.creational.builder.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Address address;
}

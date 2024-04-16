package org.patterns.design.gof.creational.builder.service;

import org.patterns.design.gof.creational.builder.request.Address;
import org.patterns.design.gof.creational.builder.response.UserResponseDTO;

import java.time.LocalDate;

public interface UserResponseBuilder {

    UserResponseBuilder firstName(String firstName);

    UserResponseBuilder lastName(String lastName);

    UserResponseBuilder birthDate(LocalDate birthdate);

    UserResponseBuilder address(Address address);

    UserResponseDTO build();

    UserResponseDTO getUserResponse();
}

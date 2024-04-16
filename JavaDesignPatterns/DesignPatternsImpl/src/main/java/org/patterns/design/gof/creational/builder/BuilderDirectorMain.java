package org.patterns.design.gof.creational.builder;

import org.patterns.design.gof.creational.builder.request.Address;
import org.patterns.design.gof.creational.builder.request.User;
import org.patterns.design.gof.creational.builder.response.UserResponseDTO;
import org.patterns.design.gof.creational.builder.service.UserResponseBuilder;

import java.time.LocalDate;

public class BuilderDirectorMain {

    public static void main(String[] args) {

        User user = inputUserRequest();
        // UserResponseBuilder builder = new UserResponseDTO.UserResponseBuilderImpl();
        UserResponseBuilder builder = UserResponseDTO.getBuilder();
        UserResponseDTO responseDTO = builder.firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthdate())
                .address(user.getAddress())
                .build();
        System.out.println(responseDTO);
        System.out.println(builder.getUserResponse());

    }

    private static User inputUserRequest() {
        Address address = new Address();
        address.setHouseNumber("10");
        address.setStreet("Abirami Nagar");
        address.setCity("Coimbatore");
        address.setZipcode("641031");
        address.setState("TN");

        User user = new User();
        user.setFirstName("Kowsalya");
        user.setLastName("Balakrishnan");
        user.setBirthdate(LocalDate.of(1996, 3, 2));
        user.setAddress(address);
        return user;
    }
}

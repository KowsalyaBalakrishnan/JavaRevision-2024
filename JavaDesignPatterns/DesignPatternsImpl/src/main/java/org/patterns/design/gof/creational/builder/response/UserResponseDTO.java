package org.patterns.design.gof.creational.builder.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private String fullName;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "Name : " + fullName + "\n" +
                "Age: " + age + "\n" +
                "Address: " + address + "\n";
    }
}

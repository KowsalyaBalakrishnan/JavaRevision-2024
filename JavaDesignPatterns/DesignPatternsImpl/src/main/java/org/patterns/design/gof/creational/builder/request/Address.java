package org.patterns.design.gof.creational.builder.request;

import lombok.Data;

@Data
public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String zipcode;
    private String state;

    @Override
    public String toString() {
        return houseNumber + ", " +
                street + ", " +
                city + ", " +
                zipcode + ", " +
                state + ".";
    }
}

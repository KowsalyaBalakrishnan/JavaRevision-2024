package org.patterns.design.gof.creational.prototype;

import lombok.Data;

@Data
public class Address implements Cloneable {
    private String city;


    @Override
    public Address clone() {
        try {
            Address clone = (Address) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package org.patterns.design.gof.creational.prototype;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class Student implements Cloneable {

    String college = "SKCET";

    private Address address;

    abstract void department();

    @Override
    public Student clone() throws CloneNotSupportedException{
        return  (Student) super.clone();
    }
}

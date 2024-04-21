package org.patterns.design.gof.creational.prototype;

public class ITStudent extends Student{
    @Override
    public void department() {
        System.out.println("IT");
    }

    @Override
    public ITStudent clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("IT Student is not Cloneable");
    }
}

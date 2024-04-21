package org.patterns.design.gof.creational.factory.base;

public class JSONMessageType implements Message{
    @Override
    public void displayMessageType() {
        System.out.println("JSON");
    }
}

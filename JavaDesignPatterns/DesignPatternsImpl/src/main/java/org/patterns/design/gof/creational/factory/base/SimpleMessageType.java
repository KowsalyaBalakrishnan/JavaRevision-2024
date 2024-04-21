package org.patterns.design.gof.creational.factory.base;

public class SimpleMessageType implements Message{
    @Override
    public void displayMessageType() {
        System.out.println("Simple");
    }
}

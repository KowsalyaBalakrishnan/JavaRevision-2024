package org.patterns.design.gof.creational.factory;

import org.patterns.design.gof.creational.factory.base.Message;
import org.patterns.design.gof.creational.factory.creators.JSONMessageCreator;

public class FactoryDirectorMain {
    public static void main(String[] args) {
        Message json = new JSONMessageCreator().getInstance();
        json.displayMessageType();
    }
}

package org.patterns.design.gof.creational.factory.creators;

import org.patterns.design.gof.creational.factory.base.Message;
import org.patterns.design.gof.creational.factory.base.SimpleMessageType;

public class SimpleMessageCreator implements MessageObjectCreators {

    @Override
    public Message getInstance() {
        return new SimpleMessageType();
    }
}

package org.patterns.design.gof.creational.factory.creators;

import org.patterns.design.gof.creational.factory.base.JSONMessageType;
import org.patterns.design.gof.creational.factory.base.Message;

public class JSONMessageCreator implements MessageObjectCreators {

    @Override
    public Message getInstance() {
        return new JSONMessageType();
    }
}

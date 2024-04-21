package org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Wheels;

public class AlloyWheelsImpl implements WheelFactory{
    @Override
    public Wheels getWheel() {
        return Wheels.ALLOY;
    }
}

package org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Wheels;

public class SteelWheelsImpl implements WheelFactory{
    @Override
    public Wheels getWheel() {
        return Wheels.STEEL;
    }
}

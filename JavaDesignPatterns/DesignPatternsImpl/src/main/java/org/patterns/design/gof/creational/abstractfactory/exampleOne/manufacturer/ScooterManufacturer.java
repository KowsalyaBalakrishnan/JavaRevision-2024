package org.patterns.design.gof.creational.abstractfactory.exampleOne.manufacturer;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.colors.ColorFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Color;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Wheels;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels.WheelFactory;

public interface ScooterManufacturer {

    WheelFactory getWheels(Wheels wheels);

    ColorFactory getColor(Color color);
}

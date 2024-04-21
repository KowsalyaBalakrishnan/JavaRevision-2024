package org.patterns.design.gof.creational.abstractfactory.exampleOne.manufacturer;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.colors.BlueColorImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.colors.ColorFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.colors.WhiteColorImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Color;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Wheels;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels.AlloyWheelsImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels.SteelWheelsImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels.WheelFactory;

public class ScooterManufacturerImpl implements ScooterManufacturer {

    @Override
    public WheelFactory getWheels(Wheels wheels) {
        switch (wheels) {
            case ALLOY: return new AlloyWheelsImpl();
            case STEEL: return new SteelWheelsImpl();
            default: throw new IllegalArgumentException("Invalid Wheel");
        }
    }

    @Override
    public ColorFactory getColor(Color color) {
        switch (color) {
            case BLUE: return new BlueColorImpl();
            case WHITE: return new WhiteColorImpl();
            default: throw new IllegalArgumentException("Invalid Color");
        }
    }
}

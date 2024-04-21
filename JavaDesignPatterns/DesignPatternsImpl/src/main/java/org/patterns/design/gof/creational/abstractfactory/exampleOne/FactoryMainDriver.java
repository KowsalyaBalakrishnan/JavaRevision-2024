package org.patterns.design.gof.creational.abstractfactory.exampleOne;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.colors.ColorFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Color;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Wheels;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.manufacturer.ScooterManufacturer;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.manufacturer.ScooterManufacturerImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleOne.wheels.WheelFactory;

import java.util.Scanner;

public class FactoryMainDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ScooterManufacturer scooterManufacturer = new ScooterManufacturerImpl();
        System.out.println("Enter the Wheel Type : ");
        String wheel = scanner.next();
        System.out.println("Enter the Color: ");
        String color = scanner.next();

        WheelFactory wheelFactory = scooterManufacturer.getWheels(Wheels.valueOf(wheel));
        ColorFactory colorFactory = scooterManufacturer.getColor(Color.valueOf(color));

        Wheels factoryWheel = wheelFactory.getWheel();
        System.out.println("Received => " + factoryWheel.name());

        Color colorType = colorFactory.getColor();
        System.out.println("Received => " + colorType.name());
    }
}

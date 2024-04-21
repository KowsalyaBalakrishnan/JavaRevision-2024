package org.patterns.design.gof.creational.abstractfactory.exampleTwo.topLevel;

import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.BlackCoffee;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.CoffeeFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.LatteCoffee;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.NormalCoffee;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice.AppleJuice;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice.JuiceFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice.WatermelonJuice;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.CoffeeType;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.JuiceType;

public class VendingMachineFactorImpl implements VendingMachineFactory {

    @Override
    public CoffeeFactory getCoffeeFactory(CoffeeType coffeeType) {
        switch (coffeeType) {
            case BLACK_COFFEE:
                return new BlackCoffee();
            case LATTE_COFFEE:
                return new LatteCoffee();
            case NORMAL_COFFEE:
                return new NormalCoffee();
            default:
                throw new IllegalArgumentException("Invalid Type");
        }
    }

    @Override
    public JuiceFactory getJuiceFactory(JuiceType juiceType) {
        switch (juiceType) {
            case APPLE:
                return new AppleJuice();
            case WATERMELON:
                return new WatermelonJuice();
            default:
                throw new IllegalArgumentException("Invalid Type");
        }
    }
}

package org.patterns.design.gof.creational.abstractfactory.exampleTwo.topLevel;

import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.CoffeeFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice.JuiceFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.CoffeeType;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.JuiceType;

public interface VendingMachineFactory {
    CoffeeFactory getCoffeeFactory(CoffeeType coffeeType);
    JuiceFactory getJuiceFactory(JuiceType juiceType);
}

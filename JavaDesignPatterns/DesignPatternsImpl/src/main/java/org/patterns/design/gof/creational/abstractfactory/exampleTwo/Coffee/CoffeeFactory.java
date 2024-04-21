package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee;

public interface CoffeeFactory {

    String addCoffeePowder();

    String addWater();

    String addMilk();

    String getCoffee(boolean isSugarRequired);

}

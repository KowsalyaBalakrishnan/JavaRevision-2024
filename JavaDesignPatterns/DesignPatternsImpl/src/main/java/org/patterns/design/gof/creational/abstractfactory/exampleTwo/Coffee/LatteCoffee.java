package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee;

public class LatteCoffee implements CoffeeFactory {
    @Override
    public String addCoffeePowder() {
        return "Added 1 and half spoon of Coffee Powder";
    }

    @Override
    public String addWater() {
        return "Added quarter cup of Water";
    }

    @Override
    public String addMilk() {
        return "Added 3/4th cup of Milk";
    }

    public String addSugar(boolean isSugarRequired) {
        return isSugarRequired ? "Added 1 spoon of Sugar" : "Sugar is Not added";
    }

    @Override
    public String getCoffee(boolean isSugarRequired) {
        return "Latte Coffee :: \n" +
                addCoffeePowder() + "\n" + addWater() + "\n" + addMilk() + "\n" + addSugar(isSugarRequired);
    }
}

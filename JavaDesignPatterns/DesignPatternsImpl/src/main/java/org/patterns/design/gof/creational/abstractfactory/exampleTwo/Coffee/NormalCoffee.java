package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee;

public class NormalCoffee implements CoffeeFactory {

    @Override
    public String addCoffeePowder() {
        return "Added half spoon of Coffee Powder";
    }

    @Override
    public String addWater() {
        return "Added half cup of Water";
    }

    @Override
    public String addMilk() {
        return "Added half cup of Milk";
    }

    public String addSugar(boolean isSugarRequired) {
        return isSugarRequired ? "Added 1 spoon of Sugar" : "Sugar is Not added";
    }

    @Override
    public String getCoffee(boolean isSugarRequired) {
        return "Normal Coffee :: \n" +
                addCoffeePowder() + "\n" + addWater() + "\n" + addMilk() + "\n" + addSugar(isSugarRequired);
    }
}

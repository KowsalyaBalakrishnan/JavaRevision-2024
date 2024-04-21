package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee;

public class BlackCoffee implements CoffeeFactory {

    @Override
    public String addCoffeePowder() {
        return "Added half spoon of Coffee Powder";
    }

    @Override
    public String addWater() {
        return "Added 1 cup of Water";
    }

    @Override
    public String addMilk() {
        return "";
    }

    public String addSugar(boolean isSugarRequired) {
        return isSugarRequired ? "Added 1 spoon of Sugar" : "Sugar is Not added";
    }

    @Override
    public String getCoffee(boolean isSugarRequired) {
        return "Black Coffee :: \n" +
                addCoffeePowder() + "\n" + addWater() + "\n" + addSugar(isSugarRequired);
    }

}

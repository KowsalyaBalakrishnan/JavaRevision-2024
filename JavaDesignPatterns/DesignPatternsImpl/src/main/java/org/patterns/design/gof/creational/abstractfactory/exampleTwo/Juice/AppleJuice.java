package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice;

public class AppleJuice implements JuiceFactory {

    private String addMilk() {
        return "Adding 3/4th cup of Milk ";
    }

    private String sugarStatus(boolean isSugarRequired) {
        return isSugarRequired ? "With Sugar" : "Without Sugar";
    }

    @Override
    public String getFruitJuice(boolean isSugarRequired) {
        return "Apple Juice is prepared by " + addMilk() + sugarStatus(isSugarRequired);
    }

}

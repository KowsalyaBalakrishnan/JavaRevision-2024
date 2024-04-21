package org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice;

public class WatermelonJuice implements JuiceFactory {

    private String addWater() {
        return "Adding half cup of Water ";
    }

    private String sugarStatus(boolean isSugarRequired) {
        return isSugarRequired ? "With Sugar" : "Without Sugar";
    }


    @Override
    public String getFruitJuice(boolean isSugarRequired) {
        return "Apple Juice is prepared by " + addWater() + sugarStatus(isSugarRequired);
    }
}

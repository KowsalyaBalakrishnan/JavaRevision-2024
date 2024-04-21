package org.patterns.design.gof.creational.abstractfactory.exampleTwo;

import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Coffee.CoffeeFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.Juice.JuiceFactory;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.CoffeeType;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.enums.JuiceType;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.topLevel.VendingMachineFactorImpl;
import org.patterns.design.gof.creational.abstractfactory.exampleTwo.topLevel.VendingMachineFactory;

import java.util.Scanner;

public class VendingMachineMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VendingMachineFactory vendingMachineFactory = new VendingMachineFactorImpl();

        System.out.println("Enter the beverage by Pressing " + "\n" + "1 - Coffee \n2 - Juice");
        int beverageNumber = scanner.nextInt();
        if (beverageNumber == 1) {
            System.out.println("Enter the Coffee Type");
            String coffeeType = scanner.next();
            CoffeeFactory coffeeFactory = vendingMachineFactory.getCoffeeFactory(CoffeeType.valueOf(coffeeType));
            System.out.println("Do you require sugar? " + "\n" + "1 - Yes \n2 - No");
            int sugarRequired = scanner.nextInt();
            String beverage;
            if (sugarRequired == 1) {
                beverage = coffeeFactory.getCoffee(true);
            } else {
                beverage = coffeeFactory.getCoffee(false);
            }
            System.out.println(beverage);
        } else if (beverageNumber == 2) {
            System.out.println("Enter the Juice Type");
            String juiceType = scanner.next();
            JuiceFactory juiceFactory = vendingMachineFactory.getJuiceFactory(JuiceType.valueOf(juiceType));
            System.out.println("Do you require sugar? " + "\n" + "1 - Yes \n 2 - No");
            int sugarRequired = scanner.nextInt();
            String beverage;
            if (sugarRequired == 1) {
                beverage = juiceFactory.getFruitJuice(true);
            } else {
                beverage = juiceFactory.getFruitJuice(false);
            }
            System.out.println(beverage);
        }
    }
}

package implementations;

import interfaces.Shape1;
import interfaces.Shape2;

public class DiamondProblem implements Shape1, Shape2 {

    @Override
    public double computeArea() {
        return 0;
    }

    @Override
    public void print(String name) {
        System.out.println("*****************");
        Shape2.super.print(name);
        System.out.println("Print from implementations.DiamondProblem");
        System.out.println("*****************");

    }
}

package implementations;

import interfaces.Shape1;

public class Main {

    public static void main(String[] args) {

        Shape1 shape1 = new Square(10);
        double areaOfSquare = shape1.computeArea();
        System.out.println("Area of a implementations.Square => " + areaOfSquare);

        Shape1 shape12 = new Rectangle(5, 10);
        double areaOfRect = shape12.computeArea();
        System.out.println("Area of a implementations.Rectangle => " + areaOfRect);

        // Default Method
        shape1.print("implementations.Square");
        shape12.print("implementations.Rectangle");

        // Static Method
        Shape1.greet();

        // Diamond Problem
        Shape1 diamondProblem = new DiamondProblem();
        diamondProblem.print("DP");
    }
}

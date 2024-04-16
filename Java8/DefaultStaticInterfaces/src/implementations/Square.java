package implementations;

import interfaces.Shape1;

public class Square implements Shape1 {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double computeArea() {
        return Math.pow(side, 2);
    }
}

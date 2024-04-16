package interfaces;

public interface Shape1 {

    double computeArea();

    default void print(String name ) {
        System.out.println("Shape of the Object from SHAPE => " + name);
    }

    static void greet() {
        System.out.println("Good Noon!");
    }

}

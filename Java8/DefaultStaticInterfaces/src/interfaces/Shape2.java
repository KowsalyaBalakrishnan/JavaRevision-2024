package interfaces;

public interface Shape2 {

    default void print(String name ) {
        System.out.println("Shape of the Object from SHAPE2 => " + name);
    }
}

package WrapperTypes;

interface A {
    void doSomething();

    default void hello() {
        System.out.println("A");
    }
}

interface B {
    void doSomething();

    default void hello() {
        System.out.println("B");
    }
}

public class Samples implements B, A {


    public static void main(String[] args) {
        Samples samples = new Samples();
        samples.doSomething();
        samples.hello();
    }

    @Override
    public void doSomething() {
        System.out.println("Hey");
    }

    @Override
    public void hello() {
       B.super.hello();
    }

}



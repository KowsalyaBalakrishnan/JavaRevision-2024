package org.patterns.design.gof.creational.singleton;

public class Client {
    public static void main(String[] args) {

        System.out.println("EagerInitialization");
        EagerInitialization instance = EagerInitialization.getInstance();
        System.out.println(instance);

        EagerInitialization instance1 = EagerInitialization.getInstance();
        System.out.println(instance1);

        System.out.println(instance == instance1);
        System.out.println(instance.hashCode() + " " + instance1.hashCode());

        System.out.println("LazyInitialization");
        LazyInitialization lazy1 = LazyInitialization.getInstance();
        System.out.println(lazy1);

        LazyInitialization lazy2 = LazyInitialization.getInstance();
        System.out.println(lazy2);

        System.out.println(lazy1 == lazy2);
        System.out.println(lazy1.hashCode() + " " + lazy2.hashCode());

        System.out.println("LazyInitializationHolder - Executes once");
        LazyInitializationHolder.getInstance();
        LazyInitializationHolder.getInstance();

    }
}

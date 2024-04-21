package org.patterns.design.gof.creational.singleton;

public class EagerInitialization {

    // Cannot subclass as well for it's own
    private EagerInitialization() {
    }

    private static final EagerInitialization instance = new EagerInitialization();

    public static EagerInitialization getInstance() {
        return instance;
    }
}

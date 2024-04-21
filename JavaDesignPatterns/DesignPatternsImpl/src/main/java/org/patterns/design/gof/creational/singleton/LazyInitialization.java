package org.patterns.design.gof.creational.singleton;

public class LazyInitialization {

    private LazyInitialization() {}

    // Volatile - Always refers to the Main memory and not from cache in cache of Multi thread
    private static volatile LazyInitialization instance = null;

    public static LazyInitialization getInstance() {
        if (instance == null) {
            synchronized (LazyInitialization.class) {   // In case of Multithreading
                if (instance == null) { // It is required, because if one of the thread releases the lock, the other thread might create object again
                    instance = new LazyInitialization();    // It is called double-check lock
                }
            }
        }
        return instance;
    }
}

package org.patterns.design.gof.creational.singleton;

// Don't need synchronization, volatile, or double checking as how we do in usual way
public class LazyInitializationHolder {

    private LazyInitializationHolder() {
        System.out.println("In private constructor");
    }

    //NOTE that the inner static class is private
    private static class Holder {
        static final LazyInitializationHolder instance = new LazyInitializationHolder();
    }

    public static LazyInitializationHolder getInstance() {
        return Holder.instance;
    }
}

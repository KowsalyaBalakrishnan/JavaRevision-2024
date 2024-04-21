package org.patterns.design.gof.behavioral.observer;

import org.patterns.design.gof.behavioral.observer.observers.Subscriber;
import org.patterns.design.gof.behavioral.observer.observers.TechSubscriber;
import org.patterns.design.gof.behavioral.observer.subjects.JavaBrains;
import org.patterns.design.gof.behavioral.observer.subjects.YouTubeChannel;

import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {

        Subscriber subscriber = new TechSubscriber();
        subscriber.setName("TechGeeks");


        YouTubeChannel youTubeChannel = new JavaBrains();
        youTubeChannel.addSubscribers(List.of(subscriber));

        youTubeChannel.uploadVideo("Design Patterns in Detail!");

    }
}

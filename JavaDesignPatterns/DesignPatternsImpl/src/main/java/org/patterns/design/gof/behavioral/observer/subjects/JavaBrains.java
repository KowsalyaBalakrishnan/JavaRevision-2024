package org.patterns.design.gof.behavioral.observer.subjects;

import org.patterns.design.gof.behavioral.observer.observers.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class JavaBrains implements YouTubeChannel {

    String name = "JavaBrains";

    List<Subscriber> subscribersList = new ArrayList<>();

    public void addSubscribers(List<Subscriber> subscribersList) {
        this.subscribersList.addAll(subscribersList);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribersList.remove(subscriber);
    }

    @Override
    public void uploadVideo(String title) {
        System.out.println("Video Uplaoded to " + name);
        notifySubscribers(title);
    }

    @Override
    public void notifySubscribers(String title) {
        for (Subscriber subscriber : subscribersList) {
            subscriber.userNotification(title, this);
        }
    }

    @Override
    public String getChannelName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

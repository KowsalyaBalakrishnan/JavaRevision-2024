package org.patterns.design.gof.behavioral.observer.subjects;

import org.patterns.design.gof.behavioral.observer.observers.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Telusko implements YouTubeChannel {

    String name = "Telusko";

    List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscribers(List<Subscriber> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void uploadVideo(String title) {
        System.out.println("Video Uplaoded to " + name);
        notifySubscribers(title);
    }

    @Override
    public void notifySubscribers(String title) {
        for (Subscriber subscriber : subscribers) {
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

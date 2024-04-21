package org.patterns.design.gof.behavioral.observer.subjects;

import org.patterns.design.gof.behavioral.observer.observers.Subscriber;

import java.util.List;

public interface YouTubeChannel {

    void uploadVideo(String title);

    void notifySubscribers(String title);

    String getChannelName();

    void addSubscribers(List<Subscriber> subscribersList);

    void removeSubscriber(Subscriber subscriber);
}

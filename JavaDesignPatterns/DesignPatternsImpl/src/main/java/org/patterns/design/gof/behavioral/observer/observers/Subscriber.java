package org.patterns.design.gof.behavioral.observer.observers;

import org.patterns.design.gof.behavioral.observer.subjects.YouTubeChannel;

public interface Subscriber {

    void setName(String name);

    void userNotification(String title, YouTubeChannel youTubeChannel);
}

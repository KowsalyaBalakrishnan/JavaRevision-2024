package org.patterns.design.gof.behavioral.observer.observers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.patterns.design.gof.behavioral.observer.subjects.YouTubeChannel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class TechSubscriber implements Subscriber {

    private String subscriberName;

    private List<YouTubeChannel> youTubeChannels;

    public TechSubscriber(List<YouTubeChannel> youTubeChannels) {
        this.youTubeChannels = youTubeChannels;
    }

    public void subscribeToChannel(YouTubeChannel youTubeChannel) {
        youTubeChannels.add(youTubeChannel);
    }

    @Override
    public void setName(String name) {
        this.subscriberName = name;
    }

    @Override
    public void userNotification(String title, YouTubeChannel youTubeChannel) {
        System.out.println("Hey " + subscriberName + ", " + youTubeChannel.getChannelName() + " uploaded a video" +
                " about => " + title);
    }
}

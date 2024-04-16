package org.patterns.design.solid.LSP.correct;

public class AudioPlayer {
    public void playAudio() {
        System.out.println("I can play Audio");
    }
}

class VideoMediaPlayer {
    public void playVideo() {
        System.out.println("I can play Video");
    }
}

class YouTube extends VideoMediaPlayer {
    @Override
    public void playVideo() {
        System.out.println("YouTube can play Video with better quality feature");
    }
}

class AppleMusic extends AudioPlayer {
    public void playAudio() {
        System.out.println("Apple Music supports Audio with better quality");
    }
}

class Spotify extends AudioPlayer {
    public void playAudio() {
        System.out.println("Spotify supports Audio");
    }
}

class LSP {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AppleMusic();     // Substitution applied
        audioPlayer.playAudio();

        VideoMediaPlayer videoMediaPlayer = new YouTube();
        videoMediaPlayer.playVideo();
    }
}

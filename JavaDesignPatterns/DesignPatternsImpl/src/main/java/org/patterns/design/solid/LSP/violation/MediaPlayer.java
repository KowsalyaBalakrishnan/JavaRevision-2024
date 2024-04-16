package org.patterns.design.solid.LSP.violation;

// Base Class
class MediaPlayer {
    public void playAudio() {
        System.out.println("I can play Audio");
    }

    public void playVideo() {
        System.out.println("I can play Video");
    }
}

class AppleMusic extends MediaPlayer {
    @Override
    public void playAudio() {
        System.out.println("Apple Music can play Audio");
    }

    @Override
    public void playVideo() {
        throw new UnsupportedOperationException("Apple Music doesn't support video");
    }
}

class YouTube extends MediaPlayer {
    @Override
    public void playAudio() {
        System.out.println("YouTube can play Audio with better quality");
    }

    @Override
    public void playVideo() {
        System.out.println("YouTube can play Video with better quality");
    }
}

class ViolatedCode {
    public static void main(String[] args) {

        // Parent object
        MediaPlayer parent = new MediaPlayer();
        parent.playAudio();
        parent.playVideo();

        // Child Object
        MediaPlayer child = new AppleMusic();
        child.playVideo();  // Violation - exception is thrown
    }
}

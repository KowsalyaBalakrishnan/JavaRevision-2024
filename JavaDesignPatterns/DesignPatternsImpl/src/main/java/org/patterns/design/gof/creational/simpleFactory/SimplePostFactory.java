package org.patterns.design.gof.creational.simpleFactory;

public class SimplePostFactory {

    public static Post getInstance(PostType postType) {
        switch (postType) {
            case BLOG: return new BlogPost();
            case NEWS: return new NewsPost();
            default: throw new IllegalArgumentException("Post type is Invalid");
        }
    }
}

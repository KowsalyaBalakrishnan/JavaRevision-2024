package org.patterns.design.gof.creational.simpleFactory;

public class SimpleFactoryDirectorMain {

    public static void main(String[] args) {

        Post post1 = SimplePostFactory.getInstance(PostType.NEWS);
        post1.postType();

        Post post2 = SimplePostFactory.getInstance(PostType.BLOG);
        post2.postType();

        Post post3 = SimplePostFactory.getInstance(PostType.valueOf(""));
        post3.postType();
    }
}

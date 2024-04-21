package org.patterns.design.gof.creational.simpleFactory;

public class NewsPost implements Post{
    @Override
    public void postType() {
        System.out.println(PostType.NEWS);
    }
}

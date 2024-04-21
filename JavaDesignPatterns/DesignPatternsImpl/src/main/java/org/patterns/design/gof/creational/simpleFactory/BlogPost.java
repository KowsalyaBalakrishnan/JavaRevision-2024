package org.patterns.design.gof.creational.simpleFactory;

public class BlogPost implements Post{
    @Override
    public void postType() {
        System.out.println(PostType.BLOG);
    }
}

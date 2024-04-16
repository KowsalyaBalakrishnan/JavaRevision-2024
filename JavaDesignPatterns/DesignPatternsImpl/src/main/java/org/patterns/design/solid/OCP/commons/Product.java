package org.patterns.design.solid.OCP.commons;

import lombok.Data;

@Data
public class Product {
    public String name;
    public Color color;
    public Size size;
    public double price;

    public Product(String name, Color color, Size size, double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}

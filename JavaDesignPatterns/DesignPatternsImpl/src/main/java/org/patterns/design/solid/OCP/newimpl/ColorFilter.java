package org.patterns.design.solid.OCP.newimpl;

import org.patterns.design.solid.OCP.commons.Color;
import org.patterns.design.solid.OCP.commons.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ColorFilter implements ProductFilterOCP {

    private Color color;

    public ColorFilter(Color color) {
        this.color = color;
    }

    @Override
    public List<Product> applyFiltersByOCP(List<Product> products) {
        return products.stream()
                .filter(product -> product.color.equals(this.color))
                .collect(Collectors.toList());
    }
}

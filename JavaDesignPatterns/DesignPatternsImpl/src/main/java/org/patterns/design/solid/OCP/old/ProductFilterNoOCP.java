package org.patterns.design.solid.OCP.old;

import org.patterns.design.solid.OCP.commons.Color;
import org.patterns.design.solid.OCP.commons.Product;
import org.patterns.design.solid.OCP.commons.Size;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilterNoOCP {

    public List<Product> filterByColor(List<Product> products, Color color) {
        return products.stream()
                .filter(product -> product.color.equals(color))
                .collect(Collectors.toList());
    }

    public List<Product> filterBySize(List<Product> products, Size size) {
        return products.stream()
                .filter(product -> product.size.equals(size))
                .collect(Collectors.toList());
    }
}

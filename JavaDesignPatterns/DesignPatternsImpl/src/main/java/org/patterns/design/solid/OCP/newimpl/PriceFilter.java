package org.patterns.design.solid.OCP.newimpl;

import org.patterns.design.solid.OCP.commons.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements ProductFilterOCP {

    private double price;

    public PriceFilter(double price) {
        this.price = price;
    }

    @Override
    public List<Product> applyFiltersByOCP(List<Product> products) {
        return products.stream()
                .filter(product -> product.price < this.price)
                .collect(Collectors.toList());
    }
}

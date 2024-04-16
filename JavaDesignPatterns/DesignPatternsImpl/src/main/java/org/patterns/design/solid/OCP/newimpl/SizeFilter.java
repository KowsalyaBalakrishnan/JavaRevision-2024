package org.patterns.design.solid.OCP.newimpl;

import org.patterns.design.solid.OCP.commons.Product;
import org.patterns.design.solid.OCP.commons.Size;

import java.util.List;
import java.util.stream.Collectors;

public class SizeFilter implements ProductFilterOCP {

    private Size size;

    public SizeFilter(Size size) {
        this.size = size;
    }

    @Override
    public List<Product> applyFiltersByOCP(List<Product> products) {
        return products.stream()
                .filter(product -> product.size.equals(this.size))
                .collect(Collectors.toList());
    }
}

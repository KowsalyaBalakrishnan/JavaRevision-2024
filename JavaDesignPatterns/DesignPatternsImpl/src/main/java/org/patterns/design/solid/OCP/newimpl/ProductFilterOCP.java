package org.patterns.design.solid.OCP.newimpl;

import org.patterns.design.solid.OCP.commons.Product;

import java.util.List;

public interface ProductFilterOCP {

    List<Product> applyFiltersByOCP(List<Product> products);
}

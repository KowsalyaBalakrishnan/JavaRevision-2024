package org.patterns.design.solid.OCP;

import org.patterns.design.solid.OCP.commons.Color;
import org.patterns.design.solid.OCP.commons.Product;
import org.patterns.design.solid.OCP.commons.Size;
import org.patterns.design.solid.OCP.newimpl.ColorFilter;
import org.patterns.design.solid.OCP.newimpl.PriceFilter;
import org.patterns.design.solid.OCP.newimpl.ProductFilterOCP;
import org.patterns.design.solid.OCP.newimpl.SizeFilter;
import org.patterns.design.solid.OCP.old.ProductFilterNoOCP;

import java.util.List;

public class OpenClosedPrinciple {
    public static void main(String[] args) {

        Product apple = new Product("Apple", Color.GREEN, Size.SMALL, 100.0);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE, 50.75);
        Product house = new Product("House", Color.BLUE, Size.LARGE, 25.80);

        List<Product> products = List.of(apple, tree, house);

        products.forEach(System.out::println);

        // Old Way - OCP not implemented and Assume it is moved to Prod
        ProductFilterNoOCP productFilterNoOCP = new ProductFilterNoOCP();
        List<Product> filterByColor = productFilterNoOCP.filterByColor(products, Color.GREEN);
        System.out.println("**********Color Filter**********");
        filterByColor.forEach(System.out::println);

        /* If PM asked to implement one more filter [ by size ],  we are modifying the code - Product Filter class
        This is against OCP as it states, CLOSED for Modification*/
        List<Product> filterBySize = productFilterNoOCP.filterBySize(products, Size.SMALL);
        System.out.println("**********Size Filter**********");
        filterBySize.forEach(System.out::println);

        // New Way - Open for Extension and Closed for Modification
        ProductFilterOCP ocp = new ColorFilter(Color.BLUE);
        System.out.println("**********OCP Color Filter**********");
        ocp.applyFiltersByOCP(products).forEach(System.out::println);

        ocp = new SizeFilter(Size.SMALL);
        System.out.println("**********OCP Size Filter**********");
        ocp.applyFiltersByOCP(products).forEach(System.out::println);

        // Extended Price Filter as an addition
        ocp = new PriceFilter(51);
        System.out.println("**********OCP Price Filter**********");
        ocp.applyFiltersByOCP(products).forEach(System.out::println);

        // Combination Filters
        ProductFilterOCP combination = new PriceFilter(51);
        List<Product> priceFilteredProducts = combination.applyFiltersByOCP(products);
        combination = new ColorFilter(Color.BLUE);
        System.out.println("**********OCP Price + Color Filter**********");
        combination.applyFiltersByOCP(priceFilteredProducts).forEach(System.out::println);

    }
}

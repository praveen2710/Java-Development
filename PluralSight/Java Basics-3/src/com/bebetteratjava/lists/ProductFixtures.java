package com.bebetteratjava.lists;

import com.bebetteratjava.commonoperations.Product;
import com.bebetteratjava.sets.Supplier;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class ProductFixtures {
    public static Product door = new Product("Wooden Door", 35,1);
    public static Product floorPanel = new Product("Floor Panel", 25,2);
    public static Product window = new Product("Glass Window",10,3);

    public static Supplier bobs = new Supplier("Bob's Household Supplies");
    public static Supplier kates = new Supplier("Kate's Home Goods");

    static {
        bobs.getProductsSupplied().add(door);
        bobs.getProductsSupplied().add(floorPanel);

        kates.getProductsSupplied().add(floorPanel);
        kates.getProductsSupplied().add(window);
        kates.getProductsSupplied().add(new Product("Wooden Door", 35));
    }
}

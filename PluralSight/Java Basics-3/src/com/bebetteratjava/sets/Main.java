package com.bebetteratjava.sets;

import com.bebetteratjava.commonoperations.Product;

import static com.bebetteratjava.lists.ProductFixtures.bobs;
import static com.bebetteratjava.lists.ProductFixtures.kates;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Main {
    public static void main (String args[]){
        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.isSuppliedBy(bobs);
        productCatalog.isSuppliedBy(kates);

        for(Product eachProduct:productCatalog)
            System.out.println(eachProduct);
    }
}

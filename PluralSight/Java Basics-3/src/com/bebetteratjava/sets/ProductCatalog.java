package com.bebetteratjava.sets;

import com.bebetteratjava.commonoperations.Product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static com.bebetteratjava.commonoperations.Product.BY_NAME;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class ProductCatalog implements Iterable<Product> {

//    private final Set<Product> productsCatalog = new HashSet<>();
    private final Set<Product> productsCatalog = new TreeSet<>(BY_NAME);

    public void isSuppliedBy(Supplier supplier){
        productsCatalog.addAll(supplier.getProductsSupplied());
    }

    @Override
    public Iterator<Product> iterator() {
        return productsCatalog.iterator();
    }

}

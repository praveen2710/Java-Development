package com.bebetteratjava.maps;

import com.bebetteratjava.commonoperations.Product;

/**
 * Created by pb033954 on 4/4/2017.
 */
public interface ProductLookUpTable {
    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}

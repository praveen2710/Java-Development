package com.bebetteratjava.maps;

import com.bebetteratjava.commonoperations.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb033954 on 4/4/2017.
 */
public class NaiveProductLookUp implements ProductLookUpTable {

    private List<Product> products =  new ArrayList<>();

    @Override
    public Product lookupById(int id) {
        for(Product product:products){
            if(product.getId() == id)
                return  product;
        }

        return  null;
    }

    @Override
    public void addProduct(Product productToAdd) {
        for(Product product:products){
            if(product.getId() == productToAdd.getId())
                throw new IllegalArgumentException("Product with same Id exists");
        }
        products.add(productToAdd);
    }

    @Override
    public void clear() {
        products.clear();
    }
}

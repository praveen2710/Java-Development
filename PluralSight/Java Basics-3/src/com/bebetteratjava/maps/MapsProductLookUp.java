package com.bebetteratjava.maps;

import com.bebetteratjava.commonoperations.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pb033954 on 4/4/2017.
 */
public class MapsProductLookUp implements ProductLookUpTable {

    private Map<Integer,Product> idToProductMap = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return idToProductMap.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        int id = productToAdd.getId();
        if(idToProductMap.containsKey(id))
            throw new IllegalArgumentException("Product with same Id exists");
        idToProductMap.put(id,productToAdd);
    }

    @Override
    public void clear() {
        idToProductMap.clear();
    }
}

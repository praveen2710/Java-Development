package com.bebetteratjava.collectionoperations;

import com.bebetteratjava.commonoperations.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pb033954 on 4/4/2017.
 */
public class ShoppingBasket {
    private final List<Product> items = new ArrayList<>();
    public  boolean isUnModifiable = false;

    private int totalWeight = 0;

    public void add(Product product){
        items.add(product);
        totalWeight+=product.getWeight();
    }

    public List<Product> getItems(){
        if(isUnModifiable)
            return Collections.unmodifiableList(items);
        return items;
    }

    @Override
    public String toString() {
        return "ShoppingBasket of \n" + items + ", totalWeight=" + totalWeight;
    }

}

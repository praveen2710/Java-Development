package com.bebetteratjava.commonoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by pb033954 on 4/1/2017.
 */
public class Main {
    public static void main(String args[]){
        commonCollectionsOperations();
        forEachLoopLimitation();
    }

    /**
     * When using forEach loop we cannot add to the collection,remove or clear the collection.
     * This can only be done when using an iterator and is a good use case to use iterator instead
     * of for each loop
     */
    private static void forEachLoopLimitation() {
        Product door = new Product("Wodden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window",10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        try {
            //for each under the hood implements basic implementaiton of iterator
            System.out.println("For Each Loop");
            for (Product product : products) {
                if (product.getWeight() > 30)
                    System.out.println(product);
                else {
                    products.remove(product);
                    products.clear();
                    products.add(window);
            }
            }
        }catch (ConcurrentModificationException ce){
            System.out.println("No Can do will cause an exception");
            ce.printStackTrace();
        }
    }

    private static void commonCollectionsOperations() {
        Product door = new Product("Wodden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window",10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(products);

        //iterator can do things like remove from list
        System.out.println("Iterator");
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()) {
            Product product = productIterator.next();
            if(product.getWeight() > 20)
                System.out.println(product);
            else
                productIterator.remove();
        }

        //for each under the hood implements basic implementaiton of iterator
        System.out.println("For Each Loop");
        for(Product product:products){
            System.out.println(product);
        }

        System.out.println("size and isEmpty");
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println("contains");
        System.out.println(products.contains(window));
        System.out.println(products.contains(door));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);
        System.out.println("Remove all");
        products.removeAll(otherProducts);
        System.out.println(products);
    }
}

package com.bebetteratjava.collectionoperations;

import com.bebetteratjava.commonoperations.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.bebetteratjava.lists.ProductFixtures.door;
import static com.bebetteratjava.lists.ProductFixtures.floorPanel;
import static com.bebetteratjava.lists.ProductFixtures.window;

/**
 * Created by pb033954 on 4/4/2017.
 */
public class Main {

    public static void main(String args[]){
        List<Product> products = new ArrayList<>();
        /*products.add(door);
        products.add(floorPanel);
        products.add(window);*/
        Collections.addAll(products,door,floorPanel,window);
        System.out.println(products);
        final Product minByName = Collections.min(products,Product.BY_NAME);
        System.out.println(minByName);
        final Product maxByWeight = Collections.min(products,Product.BY_WEIGHT);
        System.out.println(maxByWeight);
//        operationsOnCollections(products);
//        factoriesOnCollections();
//        unModifiableGoodDesign();
    }

    /**
     * This is example of how there can be a flaw in code
     * and a good wat to fix it.
     */
    private static void unModifiableGoodDesign() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.add(door);
        System.out.println(basket);

        basket.getItems().add(window);
        System.out.println("We have gap in code");
        System.out.println(basket);

        System.out.println("This is a fix");
        basket.isUnModifiable = true;
        try {
            basket.getItems().add(window);
        }catch (UnsupportedOperationException use){
            use.printStackTrace();
        }

        basket.add(floorPanel);
        System.out.println(basket);
    }

    /**
     *singleton,emptySet
     */
    private static void factoriesOnCollections() {

        Set<Integer> set = Collections.singleton(1);
        List<String> list = Collections.singletonList("One");
        Map<Integer,String> map =Collections.singletonMap(1,"one");

//        set.add(2);
        System.out.println(set);

        Set<Integer> emptySet = Collections.emptySet();
        List<String> emptyList = Collections.emptyList();
        Map<Integer,String> emptyMap =Collections.emptyMap();

//        emptySet.add(2);
    }

    private static void operationsOnCollections(List<Product> products) {
        System.out.println(products);
        System.out.println("rotate");
        Collections.rotate(products,1);
        System.out.println(products);
        System.out.println("shuffle");
        Collections.shuffle(products);
        System.out.println(products);
        Collections.shuffle(products);
        System.out.println(products);
        System.out.println("Sorting");
        Collections.sort(products,Product.BY_NAME);
        System.out.println(products);
        Collections.sort(products,Product.BY_WEIGHT);
        System.out.println(products);

        //java8 this is better and faster than collections
        products.sort(Product.BY_WEIGHT);
    }
}

package com.bebetteratjava.lists;


import com.bebetteratjava.commonoperations.Product;

import static com.bebetteratjava.lists.ProductFixtures.door;
import static com.bebetteratjava.lists.ProductFixtures.floorPanel;
import static com.bebetteratjava.lists.ProductFixtures.window;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Main {
    public static void main(String args[]){

//        addToShipment();
//        replaceProductInShipment();
        splitProductInVans();
    }

    private static void splitProductInVans() {
        Shipment shipment = new Shipment();
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        System.out.println(shipment.getLightVanProducts());

        System.out.println(shipment.getLightVanProducts());
    }

    private static void replaceProductInShipment() {
        Shipment shipment = new Shipment();
        shipment.add(door);
        shipment.add(window);

        System.out.println("Before replace");
        //this is achieved by implementing iterable interface
        for(Product product:shipment){
            System.out.println(product);
        }

        shipment.replace(window,floorPanel);
        System.out.println("After replace");
        for(Product product:shipment){
            System.out.println(product);
        }

    }

    private static void addToShipment() {
        Shipment shipment = new Shipment();
        shipment.add(door);
        shipment.add(window);

        System.out.println(shipment);
        //this is achieved by implementing iterable interface
        for(Product product:shipment){
            System.out.println(product);
        }
    }
}

package com.bebetteratjava.maps;

import com.bebetteratjava.commonoperations.Product;
import com.bebetteratjava.lists.ProductFixtures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.bebetteratjava.lists.ProductFixtures.door;
import static com.bebetteratjava.lists.ProductFixtures.floorPanel;
import static com.bebetteratjava.lists.ProductFixtures.window;

/**
 * Created by pb033954 on 4/4/2017.
 */
public class Main {

    private static final int NUMBER_OF_PRODUCTS = 20000;
    private static final int ITERATIONS = 5;
    private static final List<Product> products = generateProducts();

    public static void main (String args[]){
//        listsVsMapPerformance();
//        viewsOverMaps();
//        sortedandNavigableMaps();
        java8features();
    }

    /**
     * THis will show you new java 8 features and how to use them
     *
     */
    private static void java8features() {
        final Product defaultProduct = new Product("Whatever",100,-1);

        final Map<Integer,Product> idToProduct = new HashMap<>();
        idToProduct.put(1, door);
        idToProduct.put(2,floorPanel);
        idToProduct.put(3, window);

        Product result = idToProduct.get(10);
        System.out.println(result);
        result = idToProduct.getOrDefault(10,defaultProduct);
        System.out.println(idToProduct);

        Product oldValue = idToProduct.replace(1,new Product("Big Door",50,1));
        System.out.println(oldValue);
        System.out.println(idToProduct.get(1));
        System.out.println("replace All");
        System.out.println(idToProduct);
        idToProduct.replaceAll((id,oldProduct)-> new Product(oldProduct.getName(),oldProduct.getWeight()+10,id));
        System.out.println(idToProduct);
        //if element is there return that else create a new one and return that element
        Product createProduct = idToProduct.computeIfAbsent(12,(id)-> new Product("Custom",10,id));
        System.out.println(createProduct);
        System.out.println(idToProduct);

        idToProduct.forEach((key,value)->
        {
            System.out.println(key+"->"+value);
        });
    }


    /**
     * THis shows how to use {@code {@link SortedMap}} and its upgrade {@code {@link NavigableMap}}
     */
    private static void sortedandNavigableMaps() {
        System.out.println("SortedMap on TreeMap");
        final SortedMap<Integer,Product> sortMap = new TreeMap<>();
        sortMap.put(1, door);
        sortMap.put(2,floorPanel);
        sortMap.put(3, window);
        sortMap.put(4,window);
        sortMap.put(5,floorPanel);
        sortMap.put(6,floorPanel);

        //this does not include the element
        SortedMap<Integer, Product> headMap = sortMap.headMap(3);
        System.out.println(headMap);
        //this includes the element
        SortedMap<Integer, Product> tailMap = sortMap.tailMap(3);
        System.out.println(tailMap);
        //start is nt included end is
        SortedMap<Integer, Product> subMap = sortMap.subMap(3,5);
        System.out.println(subMap);

        System.out.println("Navigation Map on TreeMap");
        final NavigableMap<Integer,Product> navMap = new TreeMap<>();
        navMap.put(1, door);
        navMap.put(2,floorPanel);
        navMap.put(3, window);
        navMap.put(4,window);
        navMap.put(5,floorPanel);
        navMap.put(6,floorPanel);

        int firstKey = navMap.firstKey();
        int lastKey = navMap.lastKey();
        System.out.println("First Key:"+firstKey+",lastKey:"+lastKey);
        System.out.println(navMap);
        Map.Entry<Integer, Product> pollFirst = navMap.pollFirstEntry();
        Map.Entry<Integer, Product> pollLast = navMap.pollLastEntry();
        System.out.println("Poll First Key:"+pollFirst+",Poll lastKey:"+pollLast);
        System.out.println(navMap);

        //resetting
        navMap.put(1, door);
        navMap.put(6,floorPanel);
        System.out.println("resetting the map");
        System.out.println(navMap);

        //these are >,<
        Map.Entry<Integer, Product> lowerEntry = navMap.lowerEntry(3);
        Map.Entry<Integer, Product> higherEntry = navMap.higherEntry(3);
        System.out.println("lower Entry:"+lowerEntry);
        System.out.println("lower Entry:"+higherEntry);
        int lowerKey = navMap.lowerKey(3);
        int higherKey = navMap.higherKey(3);
        System.out.println("lower Key:"+lowerKey);
        System.out.println("lower key:"+higherKey);

        //these are  <=,>=
        Map.Entry<Integer, Product> floorEntry = navMap.floorEntry(3);
        Map.Entry<Integer, Product> ceilingEntry = navMap.ceilingEntry(3);
        System.out.println("floor Entry:"+floorEntry);
        System.out.println("Ceiling Entry:"+ceilingEntry);
        int floorKey = navMap.floorKey(3);
        int ceilingKey = navMap.ceilingKey(3);
        System.out.println("floor Key:"+ceilingKey);
        System.out.println("ceiling key:"+floorKey);

        System.out.println("Flipping order of Maps");
        System.out.println(navMap.descendingMap());
        System.out.println(navMap.descendingKeySet());
        System.out.println(navMap.navigableKeySet());

        System.out.println("views over nav interface");
        System.out.println(navMap.tailMap(3));
        System.out.println(navMap.headMap(3));
        System.out.println(navMap.subMap(3,6));
        System.out.println(navMap.subMap(3,false,6,true));
    }

    private static void viewsOverMaps() {

        final Map<Integer,Product> idToProduct = new HashMap<>();
        idToProduct.put(1, door);
        idToProduct.put(2,floorPanel);
        idToProduct.put(3, window);
        idToProduct.put(5,floorPanel);
        idToProduct.put(6,floorPanel);

        System.out.println(idToProduct);

        //Set of all keys of the Map and we use set since they are unique
        //removing from this set affects original Map but we cannot add to map from thi set
        System.out.println("KeySet View");
        final Set<Integer> ids =  idToProduct.keySet();
        System.out.println(ids);
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);
        try {
            ids.add(4);
        }catch (UnsupportedOperationException use){
            use.printStackTrace();
        }

        //Set of all values in maps.This is not guaranteed to be unique since different keys can have same value.
        //hence a collection is returned.We can remove a value and only one copy of it from map will be removed.
        //we cannot add to map from here since we cannot define the key for that value
        System.out.println("Values view");
        final Collection<Product> valuesOfMap = idToProduct.values();
        System.out.println(valuesOfMap);
        System.out.println(idToProduct);
        valuesOfMap.remove(floorPanel);
        System.out.println(valuesOfMap);
        System.out.println(idToProduct);
        try {
            valuesOfMap.add(floorPanel);
        } catch (UnsupportedOperationException use){
            use.printStackTrace();
        }

        //Set of all key value pairs in map.Set since the keys will always be unique
        //We can both add and remove elements from map from here since we can define both key and value
        System.out.println("Entry Set View");
        Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
        for(Map.Entry<Integer,Product> entry:entries) {
            System.out.println(entry.getKey() + "-> Value:" + entry.getValue());
            if(entry.getKey()==3)
                entry.setValue(door);
            if(entry.getValue()==floorPanel)
                entry.setValue(window);
        }
        System.out.println(idToProduct);
    }

    private static void listsVsMapPerformance() {
        runLookups(new MapsProductLookUp());
        runLookups(new NaiveProductLookUp());
    }

    private static void runLookups(final ProductLookUpTable lookUpTable) {
        final  List<Product> products = Main.products;
        System.out.println("Running LookUp with"+lookUpTable.getClass().getSimpleName());
        for(int i=0;i<ITERATIONS;i++){
            final long startTime = System.currentTimeMillis();

            for(Product product:products)
                lookUpTable.addProduct(product);

            for(Product product:products){
                final Product result = lookUpTable.lookupById(product.getId());
                if(result != product)
                    throw new IllegalStateException("LookUp table returned wrong result for"+product);
            }
            lookUpTable.clear();
            System.out.println(System.currentTimeMillis()-startTime +"ms");

        }
    }

    private static List<Product> generateProducts(){
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator =  new Random();
        for (int i=0;i<NUMBER_OF_PRODUCTS;i++){
            products.add(new Product("Product"+i,10+weightGenerator.nextInt(10),i));
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

}

package com.bebetteratjava.lists;

import com.bebetteratjava.commonoperations.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Shipment implements Iterable<Product> {

    public  static final int LIGHT_VAN_MAX_WEIGHT = 20;
    public static int PRODUCT_NOT_PRESENT = -1;

    private final List<Product> products = new ArrayList<>();

    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

    public  void  add(Product product){
        products.add(product);
    }

    /**
     * This will replace an oldProduct with new product.
     * If oldProduct is not found it will return a message
     * @param oldProduct
     * @param newProduct
     */
    public void replace(Product oldProduct,Product newProduct){
        int index = products.indexOf(oldProduct);
        if(index !=PRODUCT_NOT_PRESENT)
            // add is different from set.Add pushes other elements down where as set replace other element
//            products.add(index,newProduct);
            products.set(index,newProduct);
        else
            System.out.println("Product Not Found");
    }

    public void prepare(){
        //sort the products by weight
        products.sort(Product.BY_WEIGHT);
        //find the product index that needs heavy van
        int splitPoint = findSplitPoint();
        //assign views of the product list for heavy and light vans
        lightVanProducts = products.subList(0,splitPoint);
        heavyVanProducts = products.subList(splitPoint,products.size());
    }

    private int findSplitPoint() {
    for(int i=0;i<products.size();i++){
        final Product product = products.get(i);
        if(product.getWeight()>LIGHT_VAN_MAX_WEIGHT)
            return i;
    }
    return 0;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public List<Product> getLightVanProducts() {return lightVanProducts;}

    public List<Product> getHeavyVanProducts() {return heavyVanProducts;}
}

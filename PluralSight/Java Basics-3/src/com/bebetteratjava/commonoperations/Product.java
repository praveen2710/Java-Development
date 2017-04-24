package com.bebetteratjava.commonoperations;

import org.hamcrest.Matcher;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

/**
 * Created by pb033954 on 4/1/2017.
 */
public class Product {
    //Java 8 collection concept
    public static final Comparator<Product> BY_WEIGHT
            = comparing(Product::getWeight);
    //Java 7
//    public static final Comparator<Product> BY_WEIGHT
//            = new Comparator<Product>()
//    {
//        public int compare(final Product p1, final Product p2)
//        {
//            return Integer.compare(p1.getWeight(), p2.getWeight());
//        }
//    };

    public static final Comparator<Product> BY_NAME
            = comparing(Product::getName);

    private String name;
    private int weight;
    private int id;


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String pName) {this.name = pName;}

    public int getWeight() {return weight;}

    public void setWeight(int pWeight) {this.weight = pWeight;}

    public Product(String pName, int weight) {
        this.name = pName;
        this.weight = weight;
    }

    public Product(String name, int weight, int id) {
        this(name,weight);
        this.id = id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
//        return name != null ? name.equals(product.name) : product.name == null;
        return Objects.equals(name,product.name);
    }

    @Override
    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + weight;
//        return result;
        return Objects.hash(name,weight);
    }
}

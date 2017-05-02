package com.bebetteratjava.outsideinTDD;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class Sale {

    private String store;
    private int qty;
    private int price;

    public Sale(String city, int qty, int price) {
        this.store = city;
        this.qty = qty;
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public int getValue(){
        return getPrice()*getQty();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "store='" + store + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}

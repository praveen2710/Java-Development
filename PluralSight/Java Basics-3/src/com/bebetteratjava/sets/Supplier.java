package com.bebetteratjava.sets;

import com.bebetteratjava.commonoperations.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb033954 on 4/2/2017.
 */
public class Supplier {

    private String supplierName;

    private List<Product> productsSupplied = new ArrayList<>();

    public String getSupplierName() {return supplierName;}

    public Supplier(String supplierName) {this.supplierName = supplierName;}

    public void setSupplierName(String supplierName) {this.supplierName = supplierName;}

    public List<Product> getProductsSupplied() {return productsSupplied;}

    public void setProductsSupplied(List<Product> productsSupplied) {this.productsSupplied = productsSupplied;}
}

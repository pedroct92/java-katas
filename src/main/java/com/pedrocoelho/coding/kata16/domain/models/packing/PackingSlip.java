package com.pedrocoelho.coding.kata16.domain.models.packing;

import com.pedrocoelho.coding.kata16.domain.models.orders.Product;

import java.util.ArrayList;
import java.util.List;

public class PackingSlip {

    private List<Product> products;

    public void addProduct(Product product) {
        if(products == null) {
            products = new ArrayList<>();
        }
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

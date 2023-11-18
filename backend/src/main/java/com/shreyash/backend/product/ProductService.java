package com.shreyash.backend.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        this.products.add(new Product("a", 1, "AD"));
    }

    public Product createNewProduct(Product product){
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return this.products;
    }

    public void removeProduct(String productURL) {
        for(Product p : products){
            if(p.getURL().equals(productURL)){
                products.remove(p);
            }
        }
    }

    public Product getProduct(String productURL) {
        for(Product p : products){
            if(p.getURL().equals(productURL)){
                return p;
            }
        }
        return new Product("Error", 100, "Errorrrr");
    }
}

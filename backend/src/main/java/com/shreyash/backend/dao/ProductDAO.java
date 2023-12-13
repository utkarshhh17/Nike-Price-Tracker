package com.shreyash.backend.dao;

import com.shreyash.backend.product.Product;
import java.util.List;

public interface ProductDAO {
    boolean insertProduct(Product product);
    Product getProduct(String URL);
    List<Product> getProducts();
    boolean removeProduct(String productURL);
}

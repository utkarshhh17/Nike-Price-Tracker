package com.shreyash.backend.dao;

import com.shreyash.backend.product.Product;
import java.util.List;

public interface ProductDAO {
    void insert(Product product);
    List<Product> getProducts();
}

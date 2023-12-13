package com.shreyash.backend.service;
import com.shreyash.backend.dao.ProductDAOImpl;
import com.shreyash.backend.product.Product;
import com.shreyash.backend.webclient.ProductWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductWebClient productWebClient;
    private ProductDAOImpl productDAO;

    @Autowired
    public ProductService(ProductWebClient productWebClient, ProductDAOImpl productDAO) {
        this.productWebClient = productWebClient;
        this.productDAO = productDAO;
    }

    public boolean createNewProduct(Product product){
        return productDAO.insertProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getProducts();
    }

    public boolean removeProduct(String productURL) {
        productDAO.removeProduct(productURL);
        return true;
    }

    public Product getProduct(String name, String id) {
        final String finalURL = "https://www.nike.com/in/t/"+name+"/"+id;
        return sendEmailIfDecreased(finalURL);
    }

    public Product sendEmailIfDecreased(String url) {

        Product current = productWebClient.checkPriceScrape(url);
        Product previous = productWebClient.checkPriceDatabase(url);

        // Send Email if price is Decreased
        if (previous.getPrice() > current.getPrice()) {
            productWebClient.sendEmailPriceDrop(current);
            return current;
        }

        // Don't send email is price is same
        return previous;
    }
}

package com.shreyash.backend.product;
import com.shreyash.backend.dao.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductWebClient productWebClient;
    private ProductDAOImpl productDAO;

    @Autowired
    public ProductService(ProductWebClient productWebClient, Data data, ProductDAOImpl productDAO) {
        this.productWebClient = productWebClient;
        this.productDAO = productDAO;
    }

    public Product createNewProduct(Product product){
        try {
            productDAO.insert(product);
            return product;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return productDAO.getProducts();
    }

    public void removeProduct(String productURL) {

    }

    public Product getProduct(String name, String id) {
        final String finalURL = "https://www.nike.com/in/t/"+name+"/"+id;
        return  null;
    }

    public Product sendEmailIfDecreased(Product product) {

        Product current = productWebClient.checkPriceScrape(product.getURL());
        Product previous = productWebClient.checkPriceDatabase(product.getURL());

        // Send Email if price is Decreased
        if (previous.getPrice() > current.getPrice()) {
            productWebClient.sendEmailPriceDrop(current);
            return current;
        }

        // Don't send email is price is same
        return previous;
    }
}

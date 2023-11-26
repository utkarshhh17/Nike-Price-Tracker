package com.shreyash.backend.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products;
    private ProductWebClient productWebClient;

    @Autowired
    public ProductService(ProductWebClient productWebClient) {
        this.productWebClient = productWebClient;
        this.products = new ArrayList<>();
        this.products.add(new Product("Nike Full Force Low", 8496, "https://www.nike.com/in/t/full-force-low-shoes-w2MKmW/FB1362-100", "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/04425b06-e340-44c4-92af-0d5aa87b7949/full-force-low-shoes-w2MKmW.png"));
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
        return new Product("Error", 100, "Errorrrr", "Snlfsag");
    }

    public String updateExistingProduct(URL url) {

        Product current = productWebClient.checkPriceScrape(url);
        Product previous = productWebClient.checkPriceDatabase(url);

        // Send Email if price is Decreased
        if (previous.getPrice() > current.getPrice()) {
            productWebClient.sendEmailPriceDrop(current);
            return "Price Decreased";
        }

        // Don't send email is price is same
        return "Price is same";
    }
}

package com.shreyash.backend.webclient;
import com.shreyash.backend.dao.ProductDAOImpl;
import com.shreyash.backend.product.Product;
import com.shreyash.backend.product.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ProductWebClient {

    private ProductDAOImpl productDAO;

    @Autowired
    public ProductWebClient(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    public Product checkPriceScrape(String url){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<URL> request = new HttpEntity<>(new URL(url), headers);

        Product productResponse = restTemplate.postForObject("http://localhost:8000/api/products", request, Product.class);

        return productResponse;
    }

    public Product checkPriceDatabase(String url){
        return productDAO.getProduct(url);
    }

    public String sendEmailPriceDrop(Product product){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        String productResponse = restTemplate.postForObject("http://localhost:8081/mail/send/", request, String.class);

        return productResponse;
    }
}

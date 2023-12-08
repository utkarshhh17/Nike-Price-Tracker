package com.shreyash.backend.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductWebClient {
    private Data data;

    @Autowired
    public ProductWebClient(Data data) {
        this.data = data;
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
        for(Product p : data.getProducts()){
            if(p.getURL().equals(url)){
                return p;
            }
        }
        return null;
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

package com.shreyash.backend.product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductWebClient {
    private List<Product> products;

    public ProductWebClient() {
        this.products = new ArrayList<>();
        this.products.add(new Product("Nike Full Force Low", 8496, "https://www.nike.com/in/t/full-force-low-shoes-w2MKmW/FB1362-100", "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/04425b06-e340-44c4-92af-0d5aa87b7949/full-force-low-shoes-w2MKmW.png"));
    }

    public Product checkPriceScrape(URL url){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<URL> request = new HttpEntity<>(url, headers);

        Product productResponse = restTemplate.postForObject("http://localhost:8000/api/products", request, Product.class);

        return productResponse;
    }

    public Product checkPriceDatabase(URL url){
        for(Product p : products){
            if(p.getURL().equals(url.getUrl())){
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

//package com.shreyash.backend.product;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Component
//@EnableScheduling
//public class ProductScheduler {
//
//    private ProductService productService;
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public ProductScheduler(ProductService productService) {
//        this.restTemplate = new RestTemplate();
//        this.productService = productService;
//    }
//
//    @Scheduled(fixedRate = 10000) // Execute every 10 seconds
//    public void sendHttpRequest() {
//        try {
//            List<Product> products = productService.getAllProducts();
//            for(Product p : products){
//
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);
//                HttpEntity<URL> request = new HttpEntity<>(new URL(p.getURL()), headers);
//                Product response = restTemplate.postForObject("http://localhost:8000/api/products", request, Product.class);
//                System.out.println("Response: " + response);
//                p.setPrice(response.getPrice());      // updating the price
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());        // print the error
//        }
//    }
//}

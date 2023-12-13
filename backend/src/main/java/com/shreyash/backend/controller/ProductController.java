package com.shreyash.backend.controller;

import com.shreyash.backend.product.Product;
import com.shreyash.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/t/{name}/{id}")
    public Product getProduct(@PathVariable String name, @PathVariable String id){
        return productService.getProduct(name, id);
    }

    @PostMapping("/products")
    public ResponseEntity<String> newProduct(@RequestBody Product product){
        if(productService.createNewProduct(product)){
            return new ResponseEntity<>("Product Added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products/{productURL}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productURL){
        if(productService.removeProduct(productURL)){
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

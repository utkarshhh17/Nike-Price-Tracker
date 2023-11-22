package com.shreyash.backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/products/{productURL}")
    public Product getProduct(@PathVariable String productURL){
        return productService.getProduct(productURL);
    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateExistingProduct(product);
    }


    @DeleteMapping("/products/{productURL}")
    public String deleteProduct(@PathVariable String productURL){
        try{
            productService.removeProduct(productURL);
            return "Successfully Deleted";
        } catch (Exception c){
            return c.toString();
        }
    }
}

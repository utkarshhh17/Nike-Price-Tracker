package com.shreyash.backend.mail;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.shreyash.backend.product.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class MailStructure {
    private Product product;

    public MailStructure() {
    }

    public MailStructure(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSubject() {
        return "Price Drop Alert";
    }

    public String getBody() {
        return "Price Dropped for "+this.product.getName()+".\nNow only at Rs "+this.product.getPrice()+"To buy click on link - "+this.product.getURL();
    }
}

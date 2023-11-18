package com.shreyash.backend.product;

public class Product {
    private String name;
    private int price;
    private String URL;

    public Product(String name, int price, String URL) {
        this.name = name;
        this.price = price;
        this.URL = URL;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

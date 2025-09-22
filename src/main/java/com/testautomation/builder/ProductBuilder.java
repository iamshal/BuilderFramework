package com.testautomation.builder;

import io.qameta.allure.Step;

public class ProductBuilder {
    private String name;
    private double price;
    private String category;
    private int quantity;

    public ProductBuilder() {
        this.quantity = 1;
    }

    @Step("Set product name: {name}")
    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Step("Set product price: {price}")
    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    @Step("Set product category: {category}")
    public ProductBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    @Step("Set product quantity: {quantity}")
    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product build() {
        return new Product(name, price, category, quantity);
    }
}

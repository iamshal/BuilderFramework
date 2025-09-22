package com.testautomation.pages;

public class CartLineItem {
    private final String title;
    private final int quantity;
    private final double price;
    private final double total;

    public CartLineItem(String title, int quantity, double price, double total) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String title() {
        return title;
    }

    public int quantity() {
        return quantity;
    }

    public double price() {
        return price;
    }

    public double total() {
        return total;
    }
}

package com.redhat.shopping.cart;

public class CartItem {

    private final int id;
    private final int price;
    private int quantity = 0;

    public CartItem(int id, int price) {
        this.id    = id;
        this.price = price;
    }

    public void increaseQuantityBy(int increment) {
        this.quantity += increment;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

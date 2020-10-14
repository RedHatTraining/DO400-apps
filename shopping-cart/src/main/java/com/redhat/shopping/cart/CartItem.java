package com.redhat.shopping.cart;

public class CartItem {
    private final int id;
    private final int price;
    private int qty = 0;

    public CartItem(int id, int price) {
        this.id    = id;
        this.price = price;
    }

    public void increaseQuantityBy(int increment) {
        this.qty += increment;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQty() {
        return this.qty;
    }
}

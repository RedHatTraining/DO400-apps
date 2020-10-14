package com.redhat.shopping.cart;

public class AddToCartCommand {
    public int id;
    public int qty;

    public AddToCartCommand() {
    }

    public AddToCartCommand(int id, int qty) {
        this.id  = id;
        this.qty = qty;
    }
}

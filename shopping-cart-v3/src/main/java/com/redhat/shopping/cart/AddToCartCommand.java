package com.redhat.shopping.cart;

public class AddToCartCommand {

    public int id;
    public int quantity;

    public AddToCartCommand() {
    }

    public AddToCartCommand(int id, int quantity) {
        this.id       = id;
        this.quantity = quantity;
    }
}

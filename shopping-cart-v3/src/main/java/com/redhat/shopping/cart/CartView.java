package com.redhat.shopping.cart;

import java.util.ArrayList;
import java.util.Collection;

public class CartView {

    public ArrayList<CartItem> products;
    public int totalItems;

    public CartView() {
    }

    public CartView(Collection<CartItem> products, int totalItems) {
        this.products   = new ArrayList<>(products);
        this.totalItems = totalItems;
    }
}

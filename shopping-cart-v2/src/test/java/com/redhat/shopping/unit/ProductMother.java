package com.redhat.shopping.unit;

import com.redhat.shopping.catalog.Product;

public class ProductMother {

    public static Product any() {
        return new Product(1, 20);
    }
}

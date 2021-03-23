package com.redhat.shopping.catalog;

public class ProductNotFoundInCatalogException extends Exception {

    public ProductNotFoundInCatalogException(String errorMessage) {
        super(errorMessage);
    }

    public static ProductNotFoundInCatalogException ofId(int id) {
        return new ProductNotFoundInCatalogException(String.format("Unable to find product with ID: %d", id));
    }
}

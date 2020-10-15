package com.redhat.shopping.catalog;

public interface Catalog {

    public Product ofId(int id) throws ProductNotFoundInCatalogException;
}

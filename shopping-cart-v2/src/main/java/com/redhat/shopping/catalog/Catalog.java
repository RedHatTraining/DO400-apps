package com.redhat.shopping.catalog;

import java.util.Collection;

public interface Catalog {
    Collection<Product> getAll();

    Product ofId(int id) throws ProductNotFoundInCatalogException;
}

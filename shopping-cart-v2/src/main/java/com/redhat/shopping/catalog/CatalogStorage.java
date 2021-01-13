package com.redhat.shopping.catalog;

import java.util.Collection;

public interface CatalogStorage {
    boolean containsKey(int id);
    Product get(int id);
    Collection<Product> getAll();
}

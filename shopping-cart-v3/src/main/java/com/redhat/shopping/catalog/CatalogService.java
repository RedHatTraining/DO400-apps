package com.redhat.shopping.catalog;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CatalogService implements Catalog {

    private final Map<Integer, Product> storage = new HashMap<>();

    /**
     * Initializes a list of 5 products with IDs from 1 to 5 and the price being the result of the ID * 100.
     * Simulates persistence with a known set of products.
     */
    public CatalogService() {
        for (int id = 1; id < 5; id++) {
            this.storage.put(id, new Product(id, id * 100));
        }
    }

    public Product ofId(int id) throws ProductNotFoundInCatalogException {
        if (!this.storage.containsKey(id)) {
            throw ProductNotFoundInCatalogException.ofId(id);
        }

        return this.storage.get(id);
    }
}

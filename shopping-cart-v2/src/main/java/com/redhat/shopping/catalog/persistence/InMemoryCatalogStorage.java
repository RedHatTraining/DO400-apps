package com.redhat.shopping.catalog.persistence;

import com.redhat.shopping.catalog.CatalogStorage;
import com.redhat.shopping.catalog.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class InMemoryCatalogStorage implements CatalogStorage {

    private final Map<Integer, Product> storage = new HashMap<>();

    private void simulateSlowStorage() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes a list of 5 products with IDs from 1 to 5 and the price being the result of the ID * 100.
     * Simulates persistence with a known set of products.
     */
    public InMemoryCatalogStorage() {
        for (int id = 1; id < 5; id++) {
            this.storage.put(id, new Product(id, id * 100));
        }
    }

    public boolean containsKey(int id) {
        return storage.containsKey(id);
    }

    public Product get(int id) {
        this.simulateSlowStorage();
        return storage.get(id);
    }

    public Collection<Product> getAll() {
        return new ArrayList<>(this.storage.values());
    }
}

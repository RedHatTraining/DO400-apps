package com.redhat.shopping.catalog;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;

@ApplicationScoped
public class CatalogService implements Catalog {

    private final CatalogStorage storage;

    public CatalogService(CatalogStorage storage) {
        this.storage = storage;
    }

    @Override
    public Collection<Product> getAll() {
        return this.storage.getAll();
    }

    public Product ofId(int id) throws ProductNotFoundInCatalogException {
        if (!this.storage.containsKey(id)) {
            throw ProductNotFoundInCatalogException.ofId(id);
        }

        return this.storage.get(id);
    }
}

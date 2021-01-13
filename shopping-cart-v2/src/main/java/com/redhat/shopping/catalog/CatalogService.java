package com.redhat.shopping.catalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CatalogService implements Catalog {

    @Inject
    CatalogStorage storage;

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

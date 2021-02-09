package com.redhat.shopping.unit.catalog;

import com.redhat.shopping.catalog.CatalogService;
import com.redhat.shopping.catalog.CatalogStorage;
import com.redhat.shopping.catalog.Product;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import com.redhat.shopping.unit.ProductMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatalogServiceTest {

    private CatalogStorage catalogStorageMock;
    private CatalogService sut;

    @BeforeEach
    public void setUp() {
        catalogStorageMock = mock(CatalogStorage.class);
        sut = new CatalogService(catalogStorageMock);
    }

    @Test
    @Tag("unit")
    public void givenNoItemsInCatalogThenGetAllReturnsEmptyCollection() {
        when(catalogStorageMock.getAll()).thenReturn(Collections.emptyList());

        assertTrue(sut.getAll().isEmpty());
    }

    @Test
    @Tag("unit")
    public void getAllReturnsCollectionWithProducts() {
        when(catalogStorageMock.getAll()).thenReturn(Collections.singletonList(ProductMother.random()));

        assertEquals(1, sut.getAll().size());
    }

    @Test
    @Tag("unit")
    public void givenProductExistsThenOfIdReturnsProduct() throws Exception {
        Product product = ProductMother.random();
        when(catalogStorageMock.containsKey(product.id())).thenReturn(true);
        when(catalogStorageMock.get(product.id())).thenReturn(product);

        assertEquals(product, sut.ofId(product.id()));
    }

    @Test
    @Tag("unit")
    public void givenProductDoesNotExistsWhenOfIdIsCalledThenProductNotFoundInCatalogExceptionIsThrown() throws Exception {
        Product product = ProductMother.random();
        when(catalogStorageMock.containsKey(product.id())).thenReturn(false);

        assertThrows(
            ProductNotFoundInCatalogException.class,
            () -> sut.ofId(product.id())
        );
    }
}

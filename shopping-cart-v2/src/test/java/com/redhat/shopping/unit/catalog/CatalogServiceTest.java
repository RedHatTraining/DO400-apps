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

@Tag("unit")
public class CatalogServiceTest {

    private CatalogStorage catalogStorageMock;
    private CatalogService catalogService;

    @BeforeEach
    public void setUp() {
        catalogStorageMock = mock(CatalogStorage.class);
        catalogService = new CatalogService(catalogStorageMock);
    }

    @Test
    public void givenNoItemsInCatalogThenGetAllReturnsEmptyCollection() {
        when(catalogStorageMock.getAll()).thenReturn(Collections.emptyList());

        assertTrue(catalogService.getAll().isEmpty());
    }

    @Test
    public void getAllReturnsCollectionWithProducts() {
        when(catalogStorageMock.getAll()).thenReturn(Collections.singletonList(ProductMother.any()));

        assertEquals(1, catalogService.getAll().size());
    }

    @Test
    public void givenProductExistsThenOfIdReturnsProduct() throws Exception {
        Product product = ProductMother.any();
        when(catalogStorageMock.containsKey(product.id())).thenReturn(true);
        when(catalogStorageMock.get(product.id())).thenReturn(product);

        assertEquals(product, catalogService.ofId(product.id()));
    }

    @Test
    public void givenProductDoesNotExistsWhenOfIdIsCalledThenProductNotFoundInCatalogExceptionIsThrown() throws Exception {
        Product product = ProductMother.any();
        when(catalogStorageMock.containsKey(product.id())).thenReturn(false);

        assertThrows(
            ProductNotFoundInCatalogException.class,
            () -> catalogService.ofId(product.id())
        );
    }
}

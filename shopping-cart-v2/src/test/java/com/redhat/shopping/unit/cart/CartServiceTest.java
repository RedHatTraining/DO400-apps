package com.redhat.shopping.unit.cart;

import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.cart.CartView;
import com.redhat.shopping.cart.ProductNotInCartException;
import com.redhat.shopping.catalog.Catalog;
import com.redhat.shopping.catalog.Product;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import com.redhat.shopping.unit.ProductMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartServiceTest {

    private Catalog catalogMock;
    private CartService sut;

    @BeforeEach
    public void setUp() {
        catalogMock = mock(Catalog.class);
        sut = new CartService(catalogMock);
    }

    @Test
    public void givenNothingIsAddedToCartThenTotalItemsReturnsZero() {
        assertEquals(0, sut.totalItems());
    }

    @Test
    public void givenNothingIsAddedToCartThenCartContentReturnsEmptyArray() {
        CartView cartView = sut.cartContent();

        assertEquals(0, cartView.totalItems);
        assertTrue(cartView.products.isEmpty());
    }

    @Test
    public void whenAnItemIsAddedToCartThenCartContentReturnsAnArrayIncludingTheItem() throws Exception {
        Product product = ProductMother.random();
        when(catalogMock.ofId(product.id())).thenReturn(product);

        sut.addProduct(product.id(), 1);

        CartView cartView = sut.cartContent();
        assertEquals(1, cartView.totalItems);
        assertEquals(product.id(), cartView.products.get(0).getId());
    }

    @Test
    public void givenAProductIsInCartWhenTheSameProductIsAddedThenQuantityIsIncreased() throws Exception {
        Product product = ProductMother.random();
        when(catalogMock.ofId(product.id())).thenReturn(product);
        addProductToSut(product);

        sut.addProduct(product.id(), 1);

        CartView cartView = sut.cartContent();
        assertEquals(2, cartView.totalItems);
        assertEquals(1, cartView.products.size());
        assertEquals(product.id(), cartView.products.get(0).getId());
    }

    @Test
    public void givenAProductIsNotInCatalogThenProductNotFoundExceptionIsThrown() throws Exception {
        when(catalogMock.ofId(1)).thenThrow(new ProductNotFoundInCatalogException(""));

        assertThrows(
            ProductNotFoundInCatalogException.class,
            () -> sut.addProduct(1, 1)
        );
    }

    @Test
    public void whenAProductIsRemovedThenCartContentDoesNotIncludeIt() throws Exception {
        Product product = ProductMother.random();
        when(catalogMock.ofId(product.id())).thenReturn(product);
        addProductToSut(product);

        sut.removeProduct(product.id());

        CartView cartView = sut.cartContent();
        assertEquals(0, cartView.totalItems);
        assertTrue(cartView.products.isEmpty());
    }

    @Test
    public void givenProductIsNotInCartWhenIsRemovedThenProductNotInCartExceptionIsThrown() throws Exception {
        Product product = ProductMother.random();
        when(catalogMock.ofId(product.id())).thenReturn(product);

        assertThrows(
            ProductNotInCartException.class,
            () -> sut.removeProduct(product.id())
        );
    }

    private void addProductToSut(Product product) throws Exception {
        sut.addProduct(product.id(), 1);
    }
}

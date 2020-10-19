package com.redhat.shopping.integration.whitebox;

import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class ShoppingCartTest {

    @Inject
    CartService cartService;

    @BeforeEach
    void clearCart() {
        this.cartService.clear();
    }

    @Test
    void addingNonExistingProductInCatalogRaisesAnException() {
        assertThrows(
            ProductNotFoundInCatalogException.class,
            () -> this.cartService.addProduct(9999, 10)
        );
    }

    @Test
    void addingNonExistingProductInCartTheTotalItemsMatchTheInitialQuantity()
            throws ProductNotFoundInCatalogException {

        // Adding a product to the cart
        this.cartService.addProduct(1, 10);

        // Assert: the total number of items in the cart is equal to the quantity we added
        assertEquals(10, this.cartService.totalItems());
    }

    @Test
    void addingProductThatIsInTheCartTheTotalItemsMatchTheSumOfQuantities()
            throws ProductNotFoundInCatalogException {

        // Adding a product to the cart with a specified initial quantity
        this.cartService.addProduct(1, 10);

        // Adding again the same product to the cart with a specified quantity
        this.cartService.addProduct(1, 100);

        // Assert: the total number of items in the cart is the sum of the initial and the incremental quantities
        assertEquals(110, this.cartService.totalItems());
    }
}

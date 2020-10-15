package com.redhat.shopping.integration.white.box;

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
            () -> {
                int nonExistingProductId = 9999;
                int qty                  = 10;

                this.cartService.addProduct(nonExistingProductId, qty);
            }
        );
    }

    @Test
    void addingNonExistingProductInCartTheTotalItemsMatchTheInitialQty() throws ProductNotFoundInCatalogException {
        int existingProductId = 1;
        int expectedQty       = 10;

        // Assert: there are no items in the cart
        assertEquals(0, this.cartService.totalItems());

        // Adding a product to the cart
        this.cartService.addProduct(existingProductId, expectedQty);

        // Assert: the total number of items in the cart is equal to qty we added
        assertEquals(expectedQty, this.cartService.totalItems());
    }

    @Test
    void addingProductThatIsInTheCartTheTotalItemsMatchTheSumOfQtys() throws ProductNotFoundInCatalogException {
        int existingProductId = 1;
        int initialQty        = 10;
        int incrementalQty    = 100;

        // Assert: there are no items in the cart
        assertEquals(0, this.cartService.totalItems());

        // Adding a product to the cart with a specified initial quantity
        this.cartService.addProduct(existingProductId, initialQty);

        // Adding again the same product to the cart with a specified quantity
        this.cartService.addProduct(existingProductId, incrementalQty);

        // Assert: the total number of items in the cart is the sum of the initial and the incremental quantities
        assertEquals(initialQty + incrementalQty, this.cartService.totalItems());
    }
}

package com.redhat.shopping.integration.black.box;

import com.redhat.shopping.cart.AddToCartCommand;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@QuarkusTest
public class ShoppingCartTest {

    @BeforeEach
    public void clearCart() {
        delete("/cart");
    }

    @Test
    public void removingNonExistingProductInCatalogReturns400() {
        int nonExistingProductId = 9999;

        // Test implementation
        given()
            .pathParam("id", nonExistingProductId)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(400);
    }

    @Test
    public void removingNonAddedProductToTheCartReturns404() {
        int existingProductId = 1;

        // Test implementation
        given()
            .pathParam("id", existingProductId)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(404);
    }

    @Test
    public void removingTheOnlyProductInCartReturns204() {
        int existingProductId = 1;

        // Setting the scenario to have the product with ID #1 already in the cart
        this.addProductToTheCartWithIdAndRandomQty(1);

        // Test implementation
        given()
            .pathParam("id", existingProductId)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void removingProductFromCartContainingMultipleAndDifferentProductsReturns200() {
        int existingProductId = 1;

        // Setting the scenario to have the products with IDs 1 and 2 already in the cart
        this.addProductToTheCartWithIdAndRandomQty(1);
        this.addProductToTheCartWithIdAndRandomQty(2);

        // Test implementation
        given()
            .pathParam("id", existingProductId)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(200);
    }

    private int randomQty() {
        return (new Random()).nextInt(10) + 1;
    }

    private void addProductToTheCartWithIdAndRandomQty(int productId) {
        AddToCartCommand productToAdd = new AddToCartCommand(productId, this.randomQty());

        given()
            .contentType("application/json")
            .body(productToAdd)
            .put("/cart");
    }
}

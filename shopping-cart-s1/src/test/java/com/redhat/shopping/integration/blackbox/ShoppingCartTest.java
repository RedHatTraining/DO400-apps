package com.redhat.shopping.integration.blackbox;

import com.redhat.shopping.cart.AddToCartCommand;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ShoppingCartTest {

    private int randomQuantity() {
        return (new Random()).nextInt(10) + 1;
    }

    private void addProductToTheCartWithIdAndRandomQuantity(int productId) {
        AddToCartCommand productToAdd = new AddToCartCommand(
            productId,
            this.randomQuantity()
        );

        given()
            .contentType("application/json")
            .body(productToAdd)
            .put("/cart");
    }

    @BeforeEach
    public void clearCart() {
        delete("/cart");
    }

    @Test
    public void removingNonExistingProductInCatalogReturns400() {
        // Test implementation
        given()
            .pathParam("id", 9999)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(400);
    }

    @Test
    public void removingNonAddedProductToTheCartReturns404() {
        // Test implementation
        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(404);
    }

    @Test
    public void removingTheOnlyProductInCartReturns204() {
        // Setting the scenario to have the product with ID #1 already in the cart
        this.addProductToTheCartWithIdAndRandomQuantity(1);

        // Test implementation
        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void removingProductFromCartContainingMultipleAndDifferentProductsReturns200() {
        // Setting the scenario to have the products with IDs 1 and 2 already in the cart
        this.addProductToTheCartWithIdAndRandomQuantity(1);
        this.addProductToTheCartWithIdAndRandomQuantity(2);

        // Test implementation
        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(200);
    }
}

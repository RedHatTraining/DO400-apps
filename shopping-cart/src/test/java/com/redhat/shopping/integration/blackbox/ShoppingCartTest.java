package com.redhat.shopping.integration.blackbox;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.redhat.shopping.cart.AddToCartCommand;

import io.quarkus.test.junit.QuarkusTest;

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
        given()
            .pathParam("id", 9999)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(400);
    }

    @Test
    public void removingNonAddedProductToTheCartReturns404() {
        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(404);
    }

    @Test
    public void removingTheOnlyProductInCartReturns204() {
        this.addProductToTheCartWithIdAndRandomQuantity(1);

        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(204);
    }
    
    @Test
    public void removingProductFromCartContainingMultipleAndDifferentProductsReturns200() {
        this.addProductToTheCartWithIdAndRandomQuantity(1);
        this.addProductToTheCartWithIdAndRandomQuantity(2);

        given()
            .pathParam("id", 1)
        .when()
            .delete("/cart/products/{id}")
        .then()
            .statusCode(200);
}
    // @todo: add integration tests
}
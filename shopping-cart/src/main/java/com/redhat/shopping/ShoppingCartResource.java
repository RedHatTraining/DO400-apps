package com.redhat.shopping;

import com.redhat.shopping.cart.AddToCartCommand;
import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.cart.CartView;
import com.redhat.shopping.cart.ProductNotInCartException;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/cart")
@Produces(APPLICATION_JSON)
public class ShoppingCartResource {

    @Inject
    CartService cartService;

    @PUT
    @Consumes(APPLICATION_JSON)
    @Operation(summary = "Adds a product to the shopping cart")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CartView.class)))
    @APIResponse(responseCode = "400", description = "Product not found in the catalog")
    public Response addToCart(AddToCartCommand request) {
        try {
            this.cartService.addProduct(request.id, request.quantity);
        } catch (ProductNotFoundInCatalogException exception) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok(this.cartService.cartContent()).build();
    }

    @DELETE
    @Operation(summary = "Removes all the content in the shopping cart")
    @APIResponse(responseCode = "204", description = "Cart emptied")
    public Response cleanCart() {
        this.cartService.clear();

        return Response.noContent().build();
    }

    @GET
    @Operation(summary = "Retrieves the shopping cart")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CartView.class)))
    public CartView getShoppingCart() {
        return this.cartService.cartContent();
    }

    @DELETE
    @Path("/products/{productId}")
    @Operation(summary = "Removes a product from the shopping cart")
    @APIResponse(responseCode = "200", description = "Product removed from the cart")
    @APIResponse(responseCode = "204", description = "Empty cart")
    @APIResponse(responseCode = "400", description = "Product not found in the catalog")
    @APIResponse(responseCode = "404", description = "Product not found in the cart")
    public Response removeFromCart(@PathParam int productId) {
        try {
            this.cartService.removeProduct(productId);

            if (this.cartService.totalProducts() == 0) {
                return Response.noContent().build();
            }

            return Response.ok().build();
        } catch (ProductNotFoundInCatalogException exception) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (ProductNotInCartException exception) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

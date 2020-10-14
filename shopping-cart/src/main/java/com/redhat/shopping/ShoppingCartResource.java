package com.redhat.shopping;

import com.redhat.shopping.cart.AddToCartCommand;
import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.cart.CartView;
import com.redhat.shopping.cart.ProductNotInCartException;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;
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
    public Response addToCart(AddToCartCommand request) {
        try {
            this.cartService.addProduct(request.id, request.qty);
        } catch (ProductNotFoundInCatalogException exception) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(this.cartService.cartContent()).build();
    }

    @DELETE
    public Response cleanCart() {
        this.cartService.clear();

        return Response.noContent().build();
    }

    @GET
    public CartView getShoppingCart() {
        return this.cartService.cartContent();
    }

    @DELETE
    @Path("/products/{productId}")
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

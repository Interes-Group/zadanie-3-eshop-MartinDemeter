package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

@Getter
@Setter
public class CartResponse {

    private Long id;


    private List<Product> shoppingList;

    private boolean payed;

    public CartResponse(Cart shoppingCart) {
        this.id = shoppingCart.getId();
        this.payed = shoppingCart.isPayed();

    }
}

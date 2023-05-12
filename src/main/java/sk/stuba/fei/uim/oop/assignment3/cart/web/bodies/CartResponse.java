package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {

    private Long id;


    private List<CartRequest> shoppingList;

    private boolean payed;

    public CartResponse(Cart shoppingCart) {
        this.id = shoppingCart.getId();
        this.payed = shoppingCart.isPayed();
        this.shoppingList = shoppingCart.getShoppingList().stream().map(CartRequest::new).collect(Collectors.toList());

    }
}

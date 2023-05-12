package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartAdd;

@Getter
@Setter
@NoArgsConstructor
public class CartRequest {

    private Long productId;

    private Long amount;

    public CartRequest(CartAdd cartAdd) {
        this.productId = cartAdd.getProduct().getId();
        this.amount = cartAdd.getAmount();
    }
}

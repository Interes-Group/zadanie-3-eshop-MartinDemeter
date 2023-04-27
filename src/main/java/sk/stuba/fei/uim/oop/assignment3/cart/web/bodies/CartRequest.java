package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Getter
@Setter
@NoArgsConstructor

public class CartRequest {

    private Long productId;

    private Long amount;

    public CartRequest(Product product) {
        this.productId = product.getId();
        this.amount = product.getAmount();
    }


}

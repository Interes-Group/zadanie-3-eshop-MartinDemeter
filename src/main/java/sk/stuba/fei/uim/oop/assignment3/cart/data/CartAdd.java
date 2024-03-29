package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class CartAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    private Long amount;
}

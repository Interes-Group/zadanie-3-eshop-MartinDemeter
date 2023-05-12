package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(orphanRemoval = true)
    private List<CartAdd> shoppingList;

    private boolean payed;

    public Cart() {this.shoppingList = new ArrayList<>(); }
}

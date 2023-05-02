package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface ICartService {

    Cart createCart();

    Cart getCardById(Long id) throws NotFoundException;

    List<Cart> getAllCard();

    void delete(Long id) throws NotFoundException;
}

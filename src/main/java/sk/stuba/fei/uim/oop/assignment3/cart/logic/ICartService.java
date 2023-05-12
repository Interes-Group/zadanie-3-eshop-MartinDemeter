package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;


public interface ICartService {

    Cart createCart();

    Cart getCardById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Cart addToCart(Long id, CartRequest cartRequest) throws NotFoundException, IllegalOperationException;

    String payForCard(Long id) throws NotFoundException, IllegalOperationException;
}

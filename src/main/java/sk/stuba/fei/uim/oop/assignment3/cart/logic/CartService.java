package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository repository;


    @Override
    public Cart createCart() {
        return this.repository.save(new Cart());    }

    @Override
    public Cart getCardById(Long id) throws NotFoundException {
        Cart Cart = this.repository.getCartById(id);
        if (Cart == null) {
            throw new  NotFoundException();
        }
        return Cart;
    }

    @Override
    public List<Cart> getAllCard() {
        return this.repository.findAll();
    }
}

package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartAdd;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartAddRepository;

@Service
public class CartAddService implements ICartAddService {

    @Autowired
    private CartAddRepository repository;

    @Override
    public CartAdd createAddEntry() {
        return this.repository.save(new CartAdd());
    }
}

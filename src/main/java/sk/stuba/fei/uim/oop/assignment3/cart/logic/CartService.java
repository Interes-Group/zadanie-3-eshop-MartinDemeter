package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartAdd;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

import java.util.Optional;


@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository repository;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartAddService cartAddService;;


    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return this.repository.save(cart);    }

    @Override
    public Cart getCardById(Long id) throws NotFoundException {
        Cart Cart = this.repository.getCartById(id);
        if (Cart == null) {
            throw new  NotFoundException();
        }
        return Cart;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Cart Cart = this.getCardById(id);
        this.repository.delete(Cart);
    }



    @Override
    public Cart addToCart(Long id, CartRequest cartRequest) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getCardById(id);
        Product product = this.productService.getProductById(cartRequest.getProductId());

        if (cart.isPayed() || (cartRequest.getAmount() > product.getAmount())) {
            throw new IllegalOperationException();
        } else {
            Optional<CartAdd> existingCartItem = cart.getShoppingList().stream()
                    .filter(cartAdd -> cartAdd.getProduct().getId().equals(product.getId()))
                    .findFirst();

            if (existingCartItem.isPresent()) {
                CartAdd cartAdd = existingCartItem.get();
                cartAdd.setAmount(cartAdd.getAmount() + cartRequest.getAmount());
            } else {
                CartAdd cartAdd = cartAddService.createAddEntry();
                cartAdd.setAmount(cartRequest.getAmount());
                cartAdd.setProduct(product);
                cart.getShoppingList().add(cartAdd);
            }

            product.setAmount(product.getAmount() - cartRequest.getAmount());
            return this.repository.save(cart);
        }
    }

    @Override
    public String payForCard(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getCardById(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();

        } else {
            double price = cart.getShoppingList().stream()
                    .mapToDouble(item -> item.getAmount() * item.getProduct().getPrice())
                    .sum();
            cart.setPayed(true);
            return String.valueOf(price);
        }
    }


}

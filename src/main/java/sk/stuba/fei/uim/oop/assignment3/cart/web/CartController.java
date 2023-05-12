package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse addCart() {
        return new CartResponse(this.service.createCart());
    }

    @GetMapping(value = "/{id}")
    public CartResponse getCart(@PathVariable("id")Long cartId) throws NotFoundException {
        return new CartResponse(this.service.getCardById(cartId));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id")Long cartId) throws NotFoundException {
        this.service.delete(cartId);
    }

    @PostMapping(value = "/{id}/add")
    public CartResponse addToCart(@PathVariable("id")Long cartId, @RequestBody CartRequest cartRequest) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(cartId, cartRequest));
    }

    @GetMapping(value = "/{id}/pay")
    public String payForCard(@PathVariable("id")Long listId) throws NotFoundException, IllegalOperationException{
        return this.service.payForCard(listId);
    }
}

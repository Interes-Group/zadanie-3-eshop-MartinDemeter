package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.service.createCart()), HttpStatus.CREATED);
    }


//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CartResponse> getAllCards() {
//        return this.service.getAllCard().stream().map(CartResponse::new).collect(Collectors.toList());
//    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id")Long cartId) throws NotFoundException {
        this.service.delete(cartId);
    }

}

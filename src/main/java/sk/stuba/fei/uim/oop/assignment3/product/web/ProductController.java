package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductUpdateRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest body) {
        return new ProductResponse(this.service.createProduct(body));
    }

    @GetMapping(value = "/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        return new ProductResponse(this.service.getProductById(productId));
    }

    @PutMapping(value = "/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long productId, @RequestBody ProductUpdateRequest body) throws NotFoundException {
        return new ProductResponse(this.service.updateProduct(productId, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) throws NotFoundException {
        this.service.deleteProduct(productId);
    }

    @GetMapping(value = "/{id}/amount")
    public Amount getAmount(@PathVariable("id") Long productId) throws NotFoundException {
        return new Amount(this.service.getAmount(productId));
    }

    @PostMapping(value = "/{id}/amount")
    public Amount addAmount(@PathVariable("id") Long productId, @RequestBody Amount body) throws NotFoundException{
        return new Amount(this.service.addAmount(productId, body.getAmount()));
    }
}
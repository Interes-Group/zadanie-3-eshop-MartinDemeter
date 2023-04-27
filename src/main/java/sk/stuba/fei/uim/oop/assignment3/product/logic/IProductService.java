package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product getProductById(Long id) throws NotFoundException;

    Product createProduct(ProductRequest request);

    Product updateProduct(Long id, ProductUpdateRequest request) throws NotFoundException;

    void deleteProduct(Long id) throws NotFoundException;

    Long getAmount(Long id) throws NotFoundException;

    Long addAmount(Long id, Long increment) throws NotFoundException;
}

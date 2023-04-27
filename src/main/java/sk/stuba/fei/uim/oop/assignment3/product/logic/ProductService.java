package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.data.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductUpdateRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        Product product = this.repository.findProductById(id);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }

    @Override
    public Product createProduct(ProductRequest request) {
        return this.repository.save(new Product(request));
    }

    @Override
    public Product updateProduct(Long id, ProductUpdateRequest request) throws NotFoundException {
        Product product = this.getProductById(id);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        return this.repository.save(product);
    }


    @Override
    public void deleteProduct(Long id) throws NotFoundException {
        this.repository.delete(this.getProductById(id));
    }

    @Override
    public Long getAmount(Long id) throws NotFoundException {
        return this.getProductById(id).getAmount();
    }

    @Override
    public Long addAmount(Long id, Long increment) throws NotFoundException {
        Product product = this.getProductById(id);
        product.setAmount(product.getAmount() + increment);
        this.repository.save(product);
        return product.getAmount();
    }

}

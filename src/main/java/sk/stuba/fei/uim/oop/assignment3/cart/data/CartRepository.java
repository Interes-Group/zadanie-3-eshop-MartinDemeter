package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAll();

    Cart getCartById(Long id);
}

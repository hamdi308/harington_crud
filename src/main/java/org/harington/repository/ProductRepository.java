package org.harington.repository;

import org.harington.model.Commande;
import org.harington.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.category=:category")
    List<Product> findProductByCategory(String category);
}

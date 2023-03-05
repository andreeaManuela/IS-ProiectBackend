package com.backend.backend.Repository;

import com.backend.backend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    Product getProductsByName(String name);
    Product getProductsByDescription(String description);

}

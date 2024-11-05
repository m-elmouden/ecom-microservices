package com.microservice.product.Dao;

import com.microservice.product.Beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Optional<Product> findById(Long id);
    void deleteById(Long id);
    Product save(Product product);
    Product findByWeight(String Weight);
    List<Product> findAll();


}

package com.omriglevi.warehouseManager.data.repository;

import com.omriglevi.warehouseManager.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

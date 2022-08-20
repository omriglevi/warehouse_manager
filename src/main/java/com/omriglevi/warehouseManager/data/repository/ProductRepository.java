package com.omriglevi.warehouseManager.data.repository;

import com.omriglevi.warehouseManager.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.price >?1 and p.price<?2")
    List<Product> findAllProductByMinMax(int min , int max);


    @Query("select p from Product p where p.qtyInStock = 0")
    List<Product> findOutOfStockProducts();

    @Query("select p from Product p where p.category = ?1 and p.brand = ?2")
    List<Product> findByCategoryAndBrand(String category, String brand);
}

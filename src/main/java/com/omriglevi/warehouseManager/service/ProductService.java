package com.omriglevi.warehouseManager.service;

import com.omriglevi.warehouseManager.data.models.Product;
import com.omriglevi.warehouseManager.data.payloads.request.ProductRequest;
import com.omriglevi.warehouseManager.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    MessageResponse createProduct(ProductRequest productRequest);
    MessageResponse updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
    Product getASingleProduct(Integer productId) throws Exception;
    List <Product> getAllProducts();
    List<Product> getByMinMaxPrice(int min, int max);
    List<Product> getOutOfStockProducts();
    List<Product> searchProductsByName(String name);
    List<Product> searchByBrandAndCategory(String category, String brand);


}

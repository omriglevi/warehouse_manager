package com.omriglevi.warehouseManager.service;

import com.omriglevi.warehouseManager.data.models.Product;
import com.omriglevi.warehouseManager.data.payloads.request.ProductRequest;
import com.omriglevi.warehouseManager.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
    MessageResponse createProduct(ProductRequest productRequest);
    MessageResponse updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
    Product getASingleProduct(Integer productId) throws Exception;
    List <Product> getAllProducts();

    }

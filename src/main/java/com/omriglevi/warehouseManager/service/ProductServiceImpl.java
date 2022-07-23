package com.omriglevi.warehouseManager.service;

import com.omriglevi.warehouseManager.data.models.Product;
import com.omriglevi.warehouseManager.data.payloads.request.ProductRequest;
import com.omriglevi.warehouseManager.data.payloads.response.MessageResponse;
import com.omriglevi.warehouseManager.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository ;

    @Override
    public MessageResponse createProduct(ProductRequest productRequest) {
        Product newProduct = new Product() ;
        newProduct.setName(productRequest.getName() );
        newProduct.setBrand(productRequest.getBrand() );
        newProduct.setColor(productRequest.getColor() );
        newProduct.setCategory(productRequest.getCategory() );
        newProduct.setPrice( productRequest.getPrice());
        newProduct.setQtyInStock( productRequest.getQtyInStock());
        System.out.println(newProduct + "!!!-------------!!!");
        productRepository.save((Product) newProduct);
        return new MessageResponse("New Product added successfully") ;



    }

    @Override
    public MessageResponse updateProduct(Integer productId, ProductRequest productRequest) {
        Optional <Product> product = productRepository.findById((productId));
        if (product.isEmpty()){
            throw new RuntimeException("d");
        }
        Product newpProd = new Product();
        newpProd.setName(productRequest.getName());
        newpProd.setBrand(productRequest.getBrand());
        newpProd.setCategory(productRequest.getCategory());
        newpProd.setColor(productRequest.getColor());
        newpProd.setPrice(productRequest.getPrice());
        newpProd.setQtyInStock(productRequest.getQtyInStock());
         productRepository.save(newpProd);
         return new MessageResponse("Updated"+productId);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);

    }

    @Override
    public Product getASingleProduct(Integer productId) throws Exception {
        return productRepository.findById(productId).orElseThrow(()-> new Exception("exc"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

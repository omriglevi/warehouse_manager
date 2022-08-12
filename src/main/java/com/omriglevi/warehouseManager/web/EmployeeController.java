package com.omriglevi.warehouseManager.web;

import com.omriglevi.warehouseManager.data.models.Product;
import com.omriglevi.warehouseManager.data.payloads.request.ProductRequest;
import com.omriglevi.warehouseManager.data.payloads.response.MessageResponse;
import com.omriglevi.warehouseManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class EmployeeController {
    @Autowired
    ProductService productService ;


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts (){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) throws Exception {
        Product product = productService.getASingleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addProduct (@RequestBody ProductRequest product){
        MessageResponse newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateProduct( @PathVariable Integer id, @RequestBody ProductRequest product) {
        MessageResponse updateEmployee = productService.updateProduct(id, product);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

 }

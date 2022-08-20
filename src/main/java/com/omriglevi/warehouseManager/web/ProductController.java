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

@RestController
@RequestMapping("/product")
public class ProductController {
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


    @GetMapping("/find/minmax")
    public  ResponseEntity<List<Product>> getAllProdByMinMaxPrice(@RequestParam(required = false) String min, @RequestParam(required = false) String max){
        if(min == null){
            min = "1";
        }
        if(max == null){
            max = "9999" ;
        }
        List<Product> products = productService.getByMinMaxPrice(Integer.parseInt(min), Integer.parseInt(max));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/outofstock")
    public  ResponseEntity<List<Product>> getAllOutOfStockProducts(){

        List<Product> products = productService.getOutOfStockProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/byname")
    public  ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name){
        List<Product> products = productService.searchProductsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/categoryandbrand")
    public  ResponseEntity<List<Product>> searchProductsByName(@RequestParam String category, @RequestParam String brand){
        List<Product> products = productService.searchByBrandAndCategory(category, brand);
        return new ResponseEntity<>(products, HttpStatus.OK);
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

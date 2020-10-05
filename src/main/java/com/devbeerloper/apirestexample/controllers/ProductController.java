package com.devbeerloper.apirestexample.controllers;

import com.devbeerloper.apirestexample.domain.Product;
import com.devbeerloper.apirestexample.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/all")
    public ResponseEntity<List<Product>> getAll () {
        return new ResponseEntity<>(productService.getAll());
    }

    @GetMapping ("/{id}")
    public Optional <Product> getProductById (@PathVariable ("id") int productId) {
        return productService.getProductById(productId);
    }
    @GetMapping ("/category/{categoryId}")
    public Optional <List<Product>> getProductsByCategory (@PathVariable ("categoryId")int categoryId) {
        return productService.getProductByCategory (categoryId);
    }
    @PostMapping ("/save")
    public Product createProduct (@RequestBody Product product) {
        return productService.save(product);
    }
    @DeleteMapping ("/delete/{id}")
    public boolean delete (@PathVariable ("id") int productId) {
        return productService.delete(productId);
    }

}

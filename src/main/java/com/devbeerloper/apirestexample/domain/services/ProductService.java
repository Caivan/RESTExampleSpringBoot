package com.devbeerloper.apirestexample.domain.services;

import com.devbeerloper.apirestexample.domain.Product;
import com.devbeerloper.apirestexample.domain.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAll () {
        return productRepository.getAll();
    }
    public Optional<Product> getProductById (int idProduct) {
        return productRepository.getProductById(idProduct);
    }
    public Optional<List<Product>> getProductByCategory (int categoryId) {
        return productRepository.getProductsByCategoria(categoryId);
    }
    public Product save (Product product) {
        return productRepository.save(product);
    }
    public boolean delete (int idProduct) {
        /*return getProductById(idProduct).map(product -> {
            productRepository.deleteProductById(idProduct);
            return true;
        }).orElse(false);*/
        if (getProductById(idProduct).isPresent()) {
            productRepository.deleteProductById(idProduct);
            return true;
        } else {
          return false;
        }
    }

}

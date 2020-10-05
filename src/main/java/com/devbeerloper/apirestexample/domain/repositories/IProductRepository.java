package com.devbeerloper.apirestexample.domain.repositories;

import com.devbeerloper.apirestexample.dataAccess.crud.ProductCrudRepository;
import com.devbeerloper.apirestexample.dataAccess.entities.Producto;
import com.devbeerloper.apirestexample.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll ();
    Optional<Product> getProductById (int productId);
    Optional<List<Product>> getProductsByCategoria (int categoryId);
    Optional<List<Product>> getEscasos (int quantity);
    Product save (Product producto);
    void deleteProductById (int productId);
}

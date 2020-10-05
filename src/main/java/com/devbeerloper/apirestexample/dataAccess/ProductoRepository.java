package com.devbeerloper.apirestexample.dataAccess;

import com.devbeerloper.apirestexample.dataAccess.crud.ProductCrudRepository;
import com.devbeerloper.apirestexample.dataAccess.entities.Producto;
import com.devbeerloper.apirestexample.dataAccess.mapper.ProductMapper;
import com.devbeerloper.apirestexample.domain.Product;
import com.devbeerloper.apirestexample.domain.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements IProductRepository {
    @Autowired
    private ProductCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List <Product> getAll () {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getProductById (int id) {
        Optional<Producto> producto = productoCrudRepository.findById(id);
        return producto.map(prod -> productMapper.toProduct(prod));
    }

    @Override
    public Optional<List<Product>> getProductsByCategoria (int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getEscasos (int escasosCantidad) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstadoIsTrue (escasosCantidad);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Product save (Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    public void deleteProductById (int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}

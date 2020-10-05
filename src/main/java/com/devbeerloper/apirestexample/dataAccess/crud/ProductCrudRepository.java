package com.devbeerloper.apirestexample.dataAccess.crud;

import com.devbeerloper.apirestexample.dataAccess.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository <Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc (int idCategoria);
    Optional <List<Producto>> findByCantidadStockLessThanAndEstadoIsTrue (int cantidadStock);
}

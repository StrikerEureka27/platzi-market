package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// Clase    // tipo pk
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    /* Aplicando el crud repository */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findBycantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



    /* -- Utilizando una Query nativa --
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> BuscarPorIdCategoria(int idCategoria);*/

}

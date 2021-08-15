package com.platzimarket.domain.repository;

import com.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ProductRepository {
        /* Esta interfaz funcionara como referencia para los
        metodos que deseemos implemetar sobre product
         */
        List<Product>getAll();
        Optional<List<Product>> getByCategory(int categoryId);
        Optional<List<Product>> getScarseProducts(int quantity);
        Optional<Product> getProduct(int productId);
        Product save(Product product);
        void delete(int productId);



}

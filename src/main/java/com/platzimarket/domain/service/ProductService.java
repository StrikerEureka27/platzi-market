package com.platzimarket.domain.service;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service /* Los servicios son los negociadores entre el repositorio y los controladores */
public class ProductService {

    @Autowired /* Internamente se inicializara un objeto de la clase ProductRepository */
    private ProductRepository productRepository;

    /* Estos se alimentan de productRepository */
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return  productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return  productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean deleteById(int productId){
        if(getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }
    }
























}

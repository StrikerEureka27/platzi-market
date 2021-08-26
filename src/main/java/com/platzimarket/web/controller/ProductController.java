package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController /* API rest */
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /* Implementando response entity */
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
                    /*Recibe dos parametros */
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") int productId){
        Optional<Product> valueProduct = productService.getProduct(productId);
        if(valueProduct.isPresent()){
            return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Optional<List<Product>>> getByCategory(@PathVariable("categoryId") int categoryId){
        Optional<List<Product>> valueCategory = productService.getByCategory(categoryId);
        if(valueCategory.isPresent()){
            return  new ResponseEntity<>(productService.getByCategory(categoryId),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(productService.getByCategory(categoryId), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/scarse/{quantityId}")
    public Optional<List<Product>> getScarseProducts(@PathVariable("quantityId") int quantity){
        return productService.getScarseProducts(quantity);
    }

    @PostMapping("/save") /*El producto no viaja en el PATH viaja en la peticion http, */
    public Product save(@RequestBody Product product){
        System.out.println("Este es un log!");
        System.out.printf(product.toString());
        return productService.save(product);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void delete(@PathVariable("deleteId") int productId){
        productService.deleteById(productId);
    }


}

package com.platzimarket.web.controller;


import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.service.ProductService;
import com.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class PurchaseController {

    @Autowired /*Unicamente se puede utilizar en proyectos de Spring*/
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<Optional<List<Purchase>>> getByClient(@PathVariable("idClient") String clientId){
        return new ResponseEntity<>(purchaseService.getByClient(clientId), HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }



}

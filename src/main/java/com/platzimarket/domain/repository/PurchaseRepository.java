package com.platzimarket.domain.repository;

import com.platzimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

/*Es una especificación que deseamos definir*/
public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}

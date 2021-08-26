package com.platzimarket.persistence;

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.repository.PurchaseRepository;
import com.platzimarket.persistence.crud.CompraCrudRepository;
import com.platzimarket.persistence.entity.Compra;
import com.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchase((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        Optional<List<Compra>> compras = compraCrudRepository.findByIdCliente(clientId);
        return compras.map(compra -> mapper.toPurchase(compra));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        /* Garantizamos que esto se va a guardar en cascada */
        compra.getComprasProducto().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));

    }
}
